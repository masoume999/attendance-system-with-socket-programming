package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;

public class AddClass extends JFrame {
    private JLabel IDlbl = new JLabel("Enter ID of class :");
    private JButton enterAudiencebtn = new JButton("Enter Audience");
    private JButton backButton = new JButton("Back");
    private JTextField IDtxt = new JTextField();
    private JPanel AddClass = new JPanel();

    private String ID;
    private String result;

    public AddClass(String username,Socket socket) throws IOException {
        this.setSize(500, 600);
        this.setTitle(new methods().getInformation(username));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - getWidth() , size.height/7 - getHeight()/7);
        this.add(AddClass);
        AddClass.setLayout(null);
        AddClass.add(backButton);
        AddClass.add(enterAudiencebtn);
        AddClass.add(IDlbl);
        AddClass.add(IDtxt);
        backButton.setBounds(20,450,90,50);
        enterAudiencebtn.setBounds(380,450,90,50);
        IDlbl.setBounds(30,200,200,35);
        IDtxt.setBounds(130,200,120,35);

        backButton.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                Professor professor = new Professor(username,socket);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        enterAudiencebtn.addActionListener((ActionEvent e) -> {
            ID = IDtxt.getText();
            Client client = new Client();
            try {
                result = client.isClass(ID,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            if (!ID.equalsIgnoreCase("")) {
                    this.setVisible(false);
                    try {
                        if (result.equalsIgnoreCase("Ok")) {
                            EnterAudience enterAudience = new EnterAudience(username,ID,socket);
                        } else {
                            JOptionPane.showMessageDialog(null, "This class already exists!", "Oops!", JOptionPane.WARNING_MESSAGE);
                            FormOfProfessor formOfProfessor = new FormOfProfessor();
                        }
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
            }else
                JOptionPane.showMessageDialog(null , "Username and Password text field can not be empty");
        });
    }
}
