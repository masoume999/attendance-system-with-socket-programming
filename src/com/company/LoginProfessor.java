package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginProfessor extends JFrame {
    private String usernamestr , passwordstr;
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    private JButton showPassword = new JButton("Show Password");
    private JButton LoginKey = new JButton("Login");
    private JButton RegisterKey = new JButton("Register");
    private JLabel usernameTxt = new JLabel("Username : ");
    private JLabel passwordTxt = new JLabel("Password : ");
    private JPanel login = new JPanel();

    private String result;

    public LoginProfessor() throws IOException {
        Client client = new Client();
        Socket socket = client.creatSocket("127.0.0.1",5000);

        this.setSize(500,600);//size of JFrame
        this.setTitle("login");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - getWidth() , size.height/7 - getHeight()/7);


        this.add(login);
        login.setLayout(null);


        login.add(usernameTxt);
        login.add(passwordTxt);
        usernameTxt.setBounds(5 , 100 , 99,35 );
        passwordTxt.setBounds(5,150 , 99 , 35);

        login.add(username);
        login.add(password);
        username.setBounds(100 , 100 , 130 , 35);
        password.setBounds(100 , 150 , 130 , 35);

        login.add(showPassword);
        showPassword.setBounds(240 , 154 , 130 , 30);

        login.add(LoginKey);
        LoginKey.setBounds(120 , 200 , 85 , 40);
        login.add(RegisterKey);
        RegisterKey.setBounds(120 , 450 , 85 , 40);



        showPassword.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(null,new String(password.getPassword()));
        });

        LoginKey.addActionListener((ActionEvent e) -> {
            usernamestr=username.getText();
            passwordstr=new String(password.getPassword());
            if (!usernamestr.equalsIgnoreCase("") && !passwordstr.equalsIgnoreCase("")) {
                this.setVisible(false);
                try {
                    result = client.logIn(usernamestr,passwordstr,socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                if(result.equalsIgnoreCase("1")){
                    JOptionPane.showMessageDialog(null, "Welcome back!");
                    try {
                        Professor professor = new Professor(usernamestr,socket);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else if(result.equalsIgnoreCase("2")){
                    JOptionPane.showMessageDialog(null, "This user does not exist!", "Oops!", JOptionPane.WARNING_MESSAGE);
                    try {
                        FormOfProfessor formOfProfessor = new FormOfProfessor();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
                else if(result.equalsIgnoreCase("3")){
                    JOptionPane.showMessageDialog(null, "Username and password did not match!", "Oops!", JOptionPane.ERROR_MESSAGE);
                    try {
                        LoginProfessor loginProfessor = new LoginProfessor();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }else
                JOptionPane.showMessageDialog(null , "Username and Password text field can not be empty");
        });
        RegisterKey.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                RegisterProfessor registerProfessor = new RegisterProfessor();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

    }

}