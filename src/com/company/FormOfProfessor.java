package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FormOfProfessor extends JFrame {

    private JButton       LogIn     = new JButton("Login");
    private JButton       Register  = new JButton("Register");
    private JPanel        one       = new JPanel();
    //private BufferedImage bckgrnd   = ImageIO.read(new File("D:\\MainIcon-1.png"));
    //private JLabel label            = new JLabel(new ImageIcon(bckgrnd));
    private JLabel welcomeText      = new JLabel("                                                          ~~Welcome~~" );

    public FormOfProfessor() throws IOException {
        this.setSize(500,600);
        this.setTitle("Home");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - getWidth() , size.height/7 - getHeight()/7);
        this.add(welcomeText, BorderLayout.BEFORE_FIRST_LINE);


        //   one.add(label);
        //   label.setBounds(40,0,400 , 400);


        this.add(one);
        one.setLayout(null);
        one.add(LogIn);
        one.add(Register);
        LogIn.setBounds(200,200,90,50);
        Register.setBounds(200,300,90,50);
        //LogIn.setBackground(Color.pink);
        //Register.setBackground(Color.pink);



        LogIn.addActionListener((ActionEvent e)->{
            this.setVisible(false);
            try {
                LoginProfessor loginProfessor = new LoginProfessor();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        Register.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                RegisterProfessor registerProfessor = new RegisterProfessor();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public static void main(String[] args) throws IOException {
       FormOfProfessor formOfProfessor = new FormOfProfessor();
    }

}
