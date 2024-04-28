package com.company;

import java.net.*;
import java.io.*;
import java.sql.DataTruncation;

public class Client
{
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    private int bytesRead;
    private int current = 0;
    public FileOutputStream fos = null;
    public BufferedOutputStream bos = null;
    public final static String
            FILE_TO_RECEIVED = "C:/Users/asus/Downloads/down.csv";
    public final static int FILE_SIZE = 6022386;
    public InputStream is;


    public Socket creatSocket(String address, int port) throws IOException {
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
            input = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return socket;
    }

    public String isUser(String username,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "isUser+" + username;
        out.writeUTF(str);
        return input.readUTF();
    }

    public void saveUser(String firstname,String lastname,String username,String password,String role,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "saveUser+" + firstname + "+" + lastname + "+" + username + "+" + password + "+" + role;
        out.writeUTF(str);
    }

    public String logIn(String username,String password,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "logIn+" + username + "+" + password;
        out.writeUTF(str);
        return input.readUTF();
    }

    public int counterStudentClass(String username, Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "counterStudentClass+" + username;
        out.writeUTF(str);
        int counter = Integer.parseInt(input.readUTF());
        return counter;
    }

    public String[] getStudendClass(int counter,String username,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "getStudendClass+" + String.valueOf(counter) + "+" + username;
        out.writeUTF(str);
        String[] array = input.readUTF().split("\\$");
        return array;
    }

    public void addAttendees(String username,String className,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "addAttendees+" + username + "+" + className;
        out.writeUTF(str);
    }

    public void deleteAttendees(String username,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "deleteAttendees+" + username;
        out.writeUTF(str);
    }

    public int counterClass(Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        int counter = 0;
        String str = "counterClass+";
        out.writeUTF(str);
        try {
            counter = Integer.parseInt(input.readUTF());
            System.out.println(counter);
            return counter;
        }
        catch (EOFException e){
            System.out.println("End of file");
        }
        return counter;
    }

    public String[] getClass(int counter,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "getClass+" + counter;
        String[] array1 = new String[10];
        try {
            out.writeUTF(str);
            String[] array = input.readUTF().split("\\$");
            return array;
        }
        catch (EOFException e){
            System.out.println("End of file");
        }
        return array1;
    }

    public String isClass(String ID,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "isClass+" + ID;
        out.writeUTF(str);
        return input.readUTF();
    }

    public int Counter(Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "Counter+";
        out.writeUTF(str);
        int counter = Integer.parseInt(input.readUTF());
        return counter;
    }

    public String[] getStudents(int counter,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "getStudents+" + counter;
        out.writeUTF(str);
        String[] array = input.readUTF().split("\\+");
        return array;
    }

    public void saveClass(String[] array,String ID,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String arr = array[0];
        for(int i=1; i< array.length ; i++){
            arr = arr + "$" + array[i];
        }
        String str = "saveClass+" + arr + "+" + ID;
        out.writeUTF(str);
    }

    public void creatCSV(String className,Socket socket) throws IOException {
        input = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        String str = "creatCSV+" + className;
        out.writeUTF(str);
    }

    public void downloadAttendees(Socket socket) throws IOException {
        int bytesRead;
        int current = 0;
        try {
            // receive file
            byte [] mybytearray  = new byte [FILE_SIZE];
            is = socket.getInputStream();
            fos = new FileOutputStream(FILE_TO_RECEIVED);
            bos = new BufferedOutputStream(fos);
            bytesRead = is.read(mybytearray,0,mybytearray.length);
            current = bytesRead;

            do {
                bytesRead =
                        is.read(mybytearray, current, (mybytearray.length-current));
                if(bytesRead >= 0) current += bytesRead;
                System.out.println(bytesRead);
            } while(bytesRead > -1);

            bos.write(mybytearray, 0 , current);
            bos.flush();
            System.out.println("File " + FILE_TO_RECEIVED
                    + " downloaded (" + current + " bytes read)");
        }
        finally {
            if (fos != null) {
                fos.close();
                System.out.println("fos.close()");
            }
            if (bos != null) {
                bos.close();
                System.out.println("bos.close()");
            }
        }
    }
}