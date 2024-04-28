package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.net.*;
import java.io.*;

public class StudentClassroom extends JFrame {

    private JButton backButton = new JButton("Back");
    private BufferedImage bckgrnd   = ImageIO.read(new File("D:\\Class Meetings Logo.png"));
    private JLabel label            = new JLabel(new ImageIcon(bckgrnd));
    private JPanel ClassRoom = new JPanel();


    public StudentClassroom(String username, String className,Socket socket) throws IOException {
        Client client = new Client();
        client.addAttendees(username,className,socket);

        this.setSize(500,600);
        this.setTitle(className+" ("+new methods().getInformation(username)+")");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - 1100 , size.height/7 - getHeight()/7);
        this.add(ClassRoom);
        ClassRoom.setLayout(null);
        ClassRoom.add(backButton);
        backButton.setBounds(20,450,90,50);

        ClassRoom.add(label);
        label.setBounds(40,0,400 , 400);



        backButton.addActionListener((ActionEvent e) -> {
            try {
                client.deleteAttendees(username,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            this.setVisible(false);
            try {
                Student student = new Student(username,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
