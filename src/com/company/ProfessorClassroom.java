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

public class ProfessorClassroom extends JFrame {

    private JButton backButton = new JButton("Back");
    private JButton downloadAttendees = new JButton("Download file of attendees");
    private BufferedImage bckgrnd   = ImageIO.read(new File("D:\\Class Meetings Logo.png"));
    private JLabel label            = new JLabel(new ImageIcon(bckgrnd));
    private JPanel ClassRoom = new JPanel();


    public ProfessorClassroom(String username, String className,Socket socket) throws IOException {
        this.setSize(500,600);
        this.setTitle(className+" ("+new methods().getInformation(username)+")");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - getWidth() , size.height/7 - getHeight()/7);
        this.add(ClassRoom);
        ClassRoom.setLayout(null);
        ClassRoom.add(backButton);
        backButton.setBounds(20,450,90,50);
        ClassRoom.add(downloadAttendees);
        downloadAttendees.setBounds(0 , 0 , 600 , 50);

        ClassRoom.add(label);
        label.setBounds(40,40,400 , 400);



        backButton.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                ListOfClasses listOfClasses = new ListOfClasses(username,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        downloadAttendees.addActionListener((ActionEvent e) -> {
            methods methods = new methods();
            Client client = new Client();
            try {
                client.creatCSV(className,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                client.downloadAttendees(socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}
