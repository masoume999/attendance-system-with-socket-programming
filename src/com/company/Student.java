package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.Socket;


public class Student extends JFrame {

    private JButton backButton = new JButton("Back");

    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn10;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn14;
    private JButton btn15;
    private JButton btn16;
    private JButton btn17;
    private JButton btn18;
    private JButton btn19;
    private JButton btn20;

    String[] array;
    int i = 0;

    private JPanel Student = new JPanel();

    public Student(String username,Socket socket) throws IOException {
        this.setSize(500, 600);
        this.setTitle(new methods().getInformation(username));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - 1100 , size.height/7 - getHeight()/7);

        this.add(Student);
        Student.setLayout(null);
        int c = 1;
        String str;
        Client client = new Client();
        int counter = client.counterStudentClass(username,socket);
        array = new String[counter];
        array = client.getStudendClass(counter,username,socket);

        while (c <= counter){
            switch (c) {
                case 1: {
                    str = array[i];
                    btn1 = new JButton(str);
                    Student.add(btn1);
                    btn1.setBounds(180 , 5 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case  2: {
                    str = array[i];
                    btn2 = new JButton(str);
                    Student.add(btn2);
                    btn2.setBounds(180 , 45 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case 3:{
                    str = array[i];
                    btn3 = new JButton(str);
                    Student.add(btn3);
                    btn3.setBounds(180 , 85 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case 4:{
                    str = array[i];
                    btn4 = new JButton(str);
                    Student.add(btn4);
                    btn4.setBounds(180 , 125 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case 5:{
                    str = array[i];
                    btn5 = new JButton(str);
                    Student.add(btn5);
                    btn5.setBounds(180 , 165 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case 6:{
                    str = array[i];
                    btn6 = new JButton(str);
                    Student.add(btn6);
                    btn6.setBounds(180 , 205 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case 7:{
                    str = array[i];
                    btn7 = new JButton(str);
                    Student.add(btn7);
                    btn7.setBounds(180 , 245 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case 8:{
                    str = array[i];
                    btn8 = new JButton(str);
                    Student.add(btn8);
                    btn8.setBounds(180 , 285 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case 9:{
                    str = array[i];
                    btn9 = new JButton(str);
                    Student.add(btn9);
                    btn9.setBounds(180 , 325 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
                case 10:{
                    str = array[i];
                    btn10 = new JButton(str);
                    Student.add(btn10);
                    btn10.setBounds(180 , 365 , 130 , 30);
                    c++;
                    i++;
                    break;
                }
            }
        }

        Student.add(backButton);
        backButton.setBounds(20,450,90,50);


        if(counter>=1) {
            btn1.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[0],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=2){
            btn2.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[1],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=3){
            btn3.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[2],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=4){
            btn4.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[3],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=5){
            btn5.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[4],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=6){
            btn6.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[5],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=7){
            btn7.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[6],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=8){
            btn8.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[7],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=9){
            btn9.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[8],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }

        if (counter>=10){
            btn10.addActionListener((ActionEvent e) -> {
                this.setVisible(false);
                try {
                    StudentClassroom classRoom = new StudentClassroom(username,array[9],socket);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }


        backButton.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                LoginStudent loginStudent = new LoginStudent();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}