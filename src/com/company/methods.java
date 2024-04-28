package com.company;

import javax.swing.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.sql.*;

public class methods {
    public boolean isUser(String username) throws IOException {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select Username from user");

            while (rs.next()) {
                if (String.valueOf(rs.getString("Username")).equalsIgnoreCase(username)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean checkUser(String username, String password) throws IOException {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select Username,Password from user");

            while (rs.next()) {
                if (String.valueOf(rs.getString("Username")).equalsIgnoreCase(username) && String.valueOf(rs.getString("Password")).equalsIgnoreCase(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public void saveUser(String firstname, String lastname, String username, String password, String role) throws IOException {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?,?)");

            statement.setString(1, firstname);
            statement.setString(2, lastname);
            statement.setString(3, username);
            statement.setString(4, password);
            statement.setString(5, role);
            statement.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String getInformation(String username) throws IOException {
        String a="",b="";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select Username,Fname,Lname from user");

            while (rs.next()) {
                if (String.valueOf(rs.getString("Username")).equalsIgnoreCase(username)) {
                    a = rs.getString("Fname");
                    b = rs.getString("Lname");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return a+" "+b;
    }

    public Boolean isClass(String ID){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("select ID from class");

            while (rs.next()) {
                if (String.valueOf(rs.getString("ID")).equalsIgnoreCase(ID)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public int Counter() throws FileNotFoundException {
        int counter = 0;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) FROM user WHERE Role=?");
            statement.setString(1, "Student");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                counter = rs.getInt("COUNT(*)");
            }
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
        return counter;
    }

    public String[] getStudents(int counter) {
        String[] array = new String[counter];
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("select Username from user WHERE Role=?");
            statement.setString(1, "Student");
            ResultSet rs = statement.executeQuery();

            int i = 0;
            while (rs.next()) {
                array[i] = rs.getString("Username");
                i++;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return array;
    }

    public void saveClass(String[] array,String ID){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("INSERT INTO class VALUES (?)");

            statement.setString(1, ID);
            statement.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            for (int i = 0; i < array.length; i++) {
                if (array[i] != null) {
                    PreparedStatement statement = con.prepareStatement("INSERT INTO member VALUES(?,?)");
                    statement.setString(1, ID);
                    statement.setString(2, array[i]);
                    statement.executeUpdate();
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public int counterClass(){
        int counter = 0;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) FROM class");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                counter = rs.getInt("COUNT(*)");
            }
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
        return counter;
    }

    public String[] getClass(int counter){
        String[] array = new String[counter];
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("select ID from class");
            ResultSet rs = statement.executeQuery();

            int i = 0;
            while (rs.next()) {
                array[i] = rs.getString("ID");
                i++;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return array;
    }

    public int counterStudentClass(String username){
        int counter = 0;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("select COUNT(*) from member WHERE Username=?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                counter = rs.getInt("COUNT(*)");
            }
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
        return counter;
    }

    public String[] getStudendClass(int counter, String username){
        String[] array = new String[counter];
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("select ID,Username from member WHERE Username=?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();

            int i = 0;
            while (rs.next()) {
                array[i] = rs.getString("ID");
                i++;
            }
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return array;
    }

    public static String getRole(String username){
        String role = "";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("select Role from user WHERE Username=?");
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            role = rs.getString("Role");

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
        return role;
    }

    public void addAttendees(String username,String ID) throws IOException {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("INSERT INTO attendees VALUES (?,?)");
            statement.setString(1, username);
            statement.setString(2, ID);
            statement.executeUpdate();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteAttendees(String username){
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");

            PreparedStatement statement = con.prepareStatement("DELETE FROM attendees WHERE Username=?");
            statement.setString(1, username);
            statement.executeUpdate();
            con.close();


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void creatCSV(String ID){
        int counter=0;
        int member=0;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/network", "root", "1999");


            PrintWriter pw= new PrintWriter(new File("CSVfile.csv"));
            StringBuilder sb=new StringBuilder();

            PreparedStatement statement = con.prepareStatement("SELECT COUNT(*) FROM member WHERE ID=?");
            statement.setString(1, ID);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                member = rs.getInt("COUNT(*)");
            }

            String[] array = new String[member];

            statement = con.prepareStatement("SELECT Username FROM member WHERE ID=?");
            statement.setString(1, ID);
            rs = statement.executeQuery();

            int i = 0;
            while (rs.next()) {
                array[i] = rs.getString("Username");
                i++;
            }

            statement = con.prepareStatement("SELECT COUNT(*) FROM attendees WHERE ID=?");
            statement.setString(1, ID);
            rs = statement.executeQuery();

            while (rs.next()) {
                counter = rs.getInt("COUNT(*)");
            }

            String[] array1 = new String[counter];

            statement = con.prepareStatement("SELECT Username FROM attendees WHERE ID=?");
            statement.setString(1, ID);
            rs = statement.executeQuery();

            i = 0;
            while (rs.next()) {
                array1[i] = rs.getString("Username");
                i++;
            }

            statement = con.prepareStatement("SELECT COUNT(*) FROM attendancelist WHERE ID=? GROUP BY Username");
            statement.setString(1, ID);
            rs = statement.executeQuery();

            while (rs.next()) {
                counter = rs.getInt("COUNT(*)");
            }

            String[] date = new String[counter];

            statement = con.prepareStatement("SELECT Date FROM attendancelist WHERE ID=? GROUP BY Date");
            statement.setString(1, ID);
            rs = statement.executeQuery();

            i = 0;
            while (rs.next()) {
                date[i] = rs.getString("Date");
                i++;
            }

            sb.append("Username");
            sb.append(",");
            for(i=0; i<date.length; i++){
                sb.append(date[i]);
                sb.append(",");
            }
            java.util.Date currentDate = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
            String dateOnly = dateFormat. format(currentDate);
            sb.append(dateOnly);
            sb.append("\r\n");

            for(int k=0; k<array.length; k++){
                statement = con.prepareStatement("SELECT Status FROM attendancelist WHERE ID=? AND Username=? GROUP BY Username,Date");
                statement.setString(1, ID);
                statement.setString(2, array[k]);
                rs = statement.executeQuery();

                sb.append(array[k]);
                while (rs.next()) {
                    sb.append(",");
                    sb.append(rs.getString("Status"));
                }
                sb.append(",");
                boolean isPresent = isPresent(array[k],array1);
                String status = "";
                if(isPresent){
                    sb.append("+");
                    status = "+";
                }
                else {
                    sb.append("-");
                    status = "-";
                }
                sb.append(",");
                sb.append("\r\n");
                PreparedStatement statement1 = con.prepareStatement("INSERT INTO attendancelist VALUES (?,?,?,?)");
                statement1.setString(1, array[k]);
                statement1.setString(2, ID);
                statement1.setDate(3, java.sql.Date.valueOf(dateOnly));
                statement1.setString(4, status);
                statement1.executeUpdate();
            }

            pw.write(sb.toString());
            pw.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean isPresent(String username,String[] array){
        for(int i=0;i<array.length;i++){
            if(username.equalsIgnoreCase(array[i]))
                return true;
        }
        return false;
    }

}