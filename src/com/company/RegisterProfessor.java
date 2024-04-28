package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;


public class RegisterProfessor extends JFrame {
    private String firstname = "", lastname = "", username = "", password = "", role ="";

    //    JScrollBar verticalScrollBar = new JScrollBar(JScrollBar.VERTICAL,10, 5, 0, 50);
//    JScrollBar horizentalScrollBar = new JScrollBar(JScrollBar.HORIZONTAL,10, 5, 0, 50);

    private JTextField   usernametxt    = new JTextField();
    private JLabel       usernamelbl    = new JLabel("User name      : ");
    private JTextField   passwordtxt         = new JTextField();
    private JLabel       passwordlbl         = new JLabel("Password      : ");
    private JTextField   firstnametxt         = new JTextField();
    private JLabel       firstnamelbl         = new JLabel("First name : ");
    private JTextField   lastnametxt         = new JTextField();
    private JLabel       lastnamelbl         = new JLabel("Last name      : ");
    private ButtonGroup  rolebtn   = new ButtonGroup();
    private JLabel       rolelbl   = new JLabel("Role      : ");
    private JRadioButton student            = new JRadioButton("Student");
    private JRadioButton professor          = new JRadioButton("Professor");


    private JPanel register = new JPanel();


    private JButton savebtn = new JButton("Save");


    public RegisterProfessor() throws IOException {
        Client client = new Client();
        Socket socket = client.creatSocket("127.0.0.1",5000);

        this.setSize(500, 600);//size of JFrame
        this.setTitle("Create profile");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - getWidth() , size.height/7 - getHeight()/7);

        this.add(register);
        register.setLayout(null);
//        createprofile.add(verticalScrollBar);
//        verticalScrollBar.setBounds(490 , 0 , 10 , 600);
//        createprofile.add(horizentalScrollBar);
//        horizentalScrollBar.setBounds(0 , 550 , 500 , 10);

        {
            register.add(usernametxt);
            usernametxt.setBounds(100, 10, 200, 30);
            register.add(usernamelbl);
            usernamelbl.setBounds(1, 10, 100, 30);
            register.add(passwordtxt);
            passwordtxt.setBounds(100, 50, 200, 30);
            register.add(passwordlbl);
            passwordlbl.setBounds(1, 50, 100, 30);
            register.add(firstnametxt);
            firstnametxt.setBounds(100, 90, 200, 30);
            register.add(firstnamelbl);
            firstnamelbl.setBounds(1, 90, 100, 30);
            register.add(lastnametxt);
            lastnametxt.setBounds(100, 130, 200, 30);
            register.add(lastnamelbl);
            lastnamelbl.setBounds(1, 130, 100, 30);
            register.add(rolelbl);
            rolelbl.setBounds(1, 170, 100, 30);
            rolebtn.add(student);
            rolebtn.add(professor);
            register.add(student);
            register.add(professor);
            student.setBounds(100, 170, 100, 30);
            professor.setBounds(200, 170, 200, 30);
        }


        register.add(savebtn);
        savebtn.setBounds(150, 450, 100, 45);


        student.addActionListener((ActionEvent e) -> {
            role = "student";
        });
        professor.addActionListener((ActionEvent e) -> {
            role = "professor";
        });

        savebtn.addActionListener((ActionEvent e) -> {
            username = usernametxt.getText();
            password = passwordtxt.getText();
            firstname = firstnametxt.getText();
            lastname = lastnametxt.getText();

            this.setVisible(false);
            try {
                if(client.isUser(username,socket).equalsIgnoreCase("Ok")) {
                    client.saveUser(firstname, lastname, username, password, role, socket);
                    JOptionPane.showMessageDialog(null, "~Welcome~\nYou are one of us now.", "hey!", JOptionPane.YES_OPTION);
                    Professor professor = new Professor(username,socket);
                }
                else{
                    JOptionPane.showMessageDialog(null, "This user already exists!", "Oops!", JOptionPane.ERROR_MESSAGE);
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

    }
}
