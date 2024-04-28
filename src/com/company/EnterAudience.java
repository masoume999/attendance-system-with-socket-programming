package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;


public class EnterAudience extends JFrame {

    private JButton otherStudents = new JButton("Other Students");
    private JButton Save = new JButton("Save");
    private JButton backButton = new JButton("Back");

    private JLabel       lbl1;
    private JLabel       lbl2;
    private JLabel       lbl3;
    private JLabel       lbl4;
    private JLabel       lbl5;
    private JLabel       lbl6;
    private JLabel       lbl7;
    private JLabel       lbl8;
    private JLabel       lbl9;
    private JLabel       lbl10;
    private JLabel       lbl11;
    private JLabel       lbl12;
    private JLabel       lbl13;
    private JLabel       lbl14;
    private JLabel       lbl15;
    private JLabel       lbl16;
    private JLabel       lbl17;
    private JLabel       lbl18;
    private JLabel       lbl19;
    private JLabel       lbl20;


    private JRadioButton btn1 = new JRadioButton();
    private JRadioButton btn2 = new JRadioButton();
    private JRadioButton btn3 = new JRadioButton();
    private JRadioButton btn4 = new JRadioButton();
    private JRadioButton btn5 = new JRadioButton();
    private JRadioButton btn6 = new JRadioButton();
    private JRadioButton btn7 = new JRadioButton();
    private JRadioButton btn8 = new JRadioButton();
    private JRadioButton btn9 = new JRadioButton();
    private JRadioButton btn10 = new JRadioButton();
    private JRadioButton btn11 = new JRadioButton();
    private JRadioButton btn12 = new JRadioButton();
    private JRadioButton btn13 = new JRadioButton();
    private JRadioButton btn14 = new JRadioButton();
    private JRadioButton btn15 = new JRadioButton();
    private JRadioButton btn16 = new JRadioButton();
    private JRadioButton btn17 = new JRadioButton();
    private JRadioButton btn18 = new JRadioButton();
    private JRadioButton btn19 = new JRadioButton();
    private JRadioButton btn20 = new JRadioButton();


    private JPanel EnterAudience = new JPanel();


    public EnterAudience(String username, String ID, Socket socket) throws IOException {
        this.setSize(500, 600);//size of JFrame
        this.setTitle(new methods().getInformation(username));
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        Toolkit tool = getToolkit();
        Dimension size = tool.getScreenSize();
        this.setLocation(size.width - getWidth() , size.height/7 - getHeight()/7);

        this.add(EnterAudience);
        EnterAudience.setLayout(null);
        int c = 1;
        int i = 0;
        String str;
        Client client = new Client();
        int counter = client.Counter(socket);
        String[] array = new String[counter];
        array = client.getStudents(counter,socket);
        while (c <= counter){
            switch (c) {
                case 1: {
                    str = array[i];
                    lbl1 = new JLabel(str);
                    EnterAudience.add(lbl1);
                    lbl1.setBounds(3, 10, 433, 30);
                    EnterAudience.add(btn1);
                    btn1.setBounds(458, 10, 25, 30);
                    c++;
                    i++;
                    break;
                }
                case  2: {
                    str = array[1];
                    lbl2 = new JLabel(str);
                    EnterAudience.add(lbl2);
                    lbl2.setBounds(3, 50, 433, 30);
                    EnterAudience.add(btn2);
                    btn2.setBounds(458, 50, 100, 30);
                    c++;
                    i++;
                    break;
                }
                case 3:{
                    str = array[i];
                    lbl3 = new JLabel(str);
                    EnterAudience.add(lbl3);
                    lbl3.setBounds(3, 90, 433, 30);
                    EnterAudience.add(btn3);
                    btn3.setBounds(458, 90, 100, 30);
                    c++;
                    i++;
                    break;
                }
                case 4:{
                    str = array[i];
                    lbl4 = new JLabel(str);
                    EnterAudience.add(lbl4);
                    lbl4.setBounds(3, 130, 433, 30);
                    EnterAudience.add(btn4);
                    btn4.setBounds(458, 130, 100, 30);
                    c++;
                    i++;
                    break;
                }
                case 5:{
                    str = array[i];
                    lbl5 = new JLabel(str);
                    EnterAudience.add(lbl5);
                    lbl5.setBounds(3, 170, 433, 30);
                    EnterAudience.add(btn5);
                    btn5.setBounds(458 , 170 , 100 , 30);
                    c++;
                    i++;
                    break;
                }
                case 6:{
                    str = array[i];
                    lbl6 = new JLabel(str);
                    EnterAudience.add(lbl6);
                    lbl6.setBounds(3, 210, 433, 30);
                    EnterAudience.add(btn6);
                    btn6.setBounds(458 , 210 , 100 , 30);
                    c++;
                    i++;
                    break;
                }
                case 7:{
                    str = array[i];
                    lbl7 = new JLabel(str);
                    EnterAudience.add(lbl7);
                    lbl7.setBounds(3, 250, 433, 30);
                    EnterAudience.add(btn7);
                    btn7.setBounds(458 , 250 , 100 , 30);
                    c++;
                    i++;
                    break;
                }
                case 8:{
                    str = array[i];
                    lbl8 = new JLabel(str);
                    EnterAudience.add(lbl8);
                    lbl8.setBounds(3, 290, 433, 30);
                    EnterAudience.add(btn8);
                    btn8.setBounds(458 , 290 , 100 , 30);
                    c++;
                    i++;
                    break;
                }
                case 9:{
                    str = array[i];
                    lbl9 = new JLabel(str);
                    EnterAudience.add(lbl9);
                    lbl9.setBounds(3, 330, 433, 30);
                    EnterAudience.add(btn9);
                    btn9.setBounds(458 , 330 , 100 , 30);
                    c++;
                    i++;
                    break;
                }
                case 10:{
                    str = array[i];
                    lbl10 = new JLabel(str);
                    EnterAudience.add(lbl10);
                    lbl10.setBounds(3, 370, 433, 30);
                    EnterAudience.add(btn10);
                    btn10.setBounds(458 , 370 , 100 , 30);
                    c++;
                    i++;
                    break;
                }
            }
        }

        EnterAudience.add(Save);
        EnterAudience.add(backButton);
        backButton.setBounds(20,450,90,50);
        Save.setBounds(340,450,130,50);


        int j = 0;

        String[] arr = new String[counter];

        String[] finalArray = array;
        int finalJ = j;
        //int finalI = i;
        btn1.addActionListener((ActionEvent e) -> {
            arr[finalJ] = finalArray[finalJ];
        });
        j++;
        int finalJ1 = j;
        btn2.addActionListener((ActionEvent e) -> {
            arr[finalJ1] = finalArray[finalJ1];
        });
        j++;
        int finalJ2 = j;
        btn3.addActionListener((ActionEvent e) -> {
            arr[finalJ2] = finalArray[finalJ2];
        });
        j++;
        int finalJ3 = j;
        btn4.addActionListener((ActionEvent e) -> {
            arr[finalJ3] = finalArray[finalJ3];
        });
        j++;
        int finalJ4 = j;
        btn5.addActionListener((ActionEvent e) -> {
            arr[finalJ4] = finalArray[finalJ4];
        });
        j++;
        int finalJ5 = j;
        btn6.addActionListener((ActionEvent e) -> {
            arr[finalJ5] = finalArray[finalJ5];
        });
        j++;
        int finalJ6 = j;
        btn7.addActionListener((ActionEvent e) -> {
            arr[finalJ6] = finalArray[finalJ6];
        });
        j++;
        int finalJ7 = j;
        btn8.addActionListener((ActionEvent e) -> {
            arr[finalJ7] = finalArray[finalJ7];
        });
        j++;
        int finalJ8 = j;
        btn9.addActionListener((ActionEvent e) -> {
            arr[finalJ8] = finalArray[finalJ8];
        });
        j++;
        int finalJ9 = j;
        btn10.addActionListener((ActionEvent e) -> {
            arr[finalJ9] = finalArray[finalJ9];
        });

        backButton.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                Professor professor = new Professor(username,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        Save.addActionListener((ActionEvent e) -> {
            this.setVisible(false);
            try {
                client.saveClass(arr,ID,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            JOptionPane.showMessageDialog(null , "New class added!");
            try {
                ListOfClasses listOfClasses = new ListOfClasses(username,socket);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
    }
}