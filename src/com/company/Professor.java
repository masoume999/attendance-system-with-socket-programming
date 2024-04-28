package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;

public class Professor extends JFrame {
    private JButton viewClasses = new JButton("View list of classes");
    private JButton addNewClass = new JButton("Add new class");
    private JButton backButton = new JButton("Back");
    private JPanel Professor = new JPanel();

    public Professor(String username, Socket socket) throws IOException {
        this.setSize(500,600);
        this.setTitle(new methods().getInformation(username));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - getWidth() , size.height/7 - getHeight()/7);
        this.add(Professor);
        Professor.setLayout(null);
        Professor.add(viewClasses);
        Professor.add(addNewClass);
        Professor.add(backButton);
        viewClasses.setBounds(75,150,350,50);
        addNewClass.setBounds(75,250,350,50);
        backButton.setBounds(20,450,90,50);


        viewClasses.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                ListOfClasses listOfClasses = new ListOfClasses(username,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        addNewClass.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                AddClass addClass = new AddClass(username,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        backButton.addActionListener((ActionEvent e) -> {
            try {
                FormOfProfessor formOfProfessor = new FormOfProfessor();
                this.setVisible(false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
}
