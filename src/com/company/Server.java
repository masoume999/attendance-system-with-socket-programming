package com.company;

import javax.swing.*;
import java.lang.reflect.Array;
import java.net.*;
import java.io.*;
public class Server
{
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private OutputStream os = null;
    private FileInputStream fis = null;
    private BufferedInputStream bis = null;
    public final static String FILE_TO_SEND = "C:/Users/asus/IdeaProjects/NetworkProject/CSVfile.csv";

    private String in;
    private String[] data;
    private String code;

    public Server(int port)
    {
        try{
            server = new ServerSocket(port);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = server.accept();
            System.out.println("Client accepted");

            input = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            output = new DataOutputStream(socket.getOutputStream());
            while(true) {
                in = input.readUTF();
                data =  in.split("\\+");
                code = data[0];
                System.out.println(data[0]);

                methods methods = new methods();

                switch (code) {
                    case "isUser":{
                        if(!methods.isUser(data[1])) {
                            output.writeUTF("Ok");
                        }
                    }

                    case "saveUser":{
                        in = input.readUTF();
                        data = in.split("\\+");
                        methods.saveUser(data[1],data[2],data[3],data[4],data[5]);
                    }

                    case "logIn": {
                        if (methods.isUser(data[1])) {
                            if (methods.checkUser(data[1], data[2])) {
                                output.writeUTF("1");
                            } else {
                                output.writeUTF("3");
                            }
                        } else {
                            output.writeUTF("2");
                        }
                        break;
                    }

                    case "counterStudentClass": {
                        int counter = methods.counterStudentClass(data[1]);
                        output.writeUTF(String.valueOf(counter));
                        break;
                    }

                    case "getStudendClass": {
                        try {
                            int counter = Integer.parseInt(data[1]);
                            String[] array = new String[counter];
                            array = methods.getStudendClass(counter,data[2]);
                            in = array[0] + "$";
                            for (int i = 1; i<array.length; i++) {
                                in = in + array[i] + "$";
                            }
                        }
                        catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("Array is full");
                        }

                        output.writeUTF(in);
                        break;
                    }

                    case "addAttendees": {
                        methods.addAttendees(data[1], data[2]);
                        break;
                    }

                    case "deleteAttendees": {
                        methods.deleteAttendees(data[1]);
                        break;
                    }

                    case "counterClass": {
                        int counter = methods.counterClass();
                        output.writeUTF(String.valueOf(counter));
                        break;
                    }

                    case "getClass": {
                        int counter = methods.counterClass();
                        String[] array = new String[counter];
                        array = methods.getClass(counter);
                        in = array[0] + "$";
                        for (int i = 1; i < array.length; i++) {
                            in = in + array[i] + "$";
                        }
                        output.writeUTF(in);
                        break;
                    }

                    case "isClass": {
                        if (!new methods().isClass(data[1])) {
                            output.writeUTF("Ok");
                            break;
                        }
                    }

                    case "Counter": {
                        int counter = methods.Counter();
                        output.writeUTF(String.valueOf(counter));
                        break;
                    }

                    case "getStudents": {
                        int counter = methods.Counter();
                        String[] array = new String[counter];
                        array = methods.getStudents(counter);
                        in = array[0] + "+";
                        for (int i = 1; i < array.length; i++) {
                            in = in + array[i] + "+";
                        }
                        output.writeUTF(in);
                        break;
                    }

                    case "saveClass": {
                        String[] arr = data[1].split("\\$");
                        methods.saveClass(arr, data[2]);
                        break;
                    }

                    case "creatCSV": {
                        try {
                            methods.creatCSV(data[1]);
                            File myFile = new File(FILE_TO_SEND);
                            byte[] mybytearray = new byte[(int) myFile.length()];
                            fis = new FileInputStream(myFile);
                            bis = new BufferedInputStream(fis);
                            bis.read(mybytearray, 0, mybytearray.length);
                            os = socket.getOutputStream();
                            System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
                            os.write(mybytearray, 0, mybytearray.length);
                            os.flush();
                            System.out.println("Done.");
                        }
                        finally {
                            if (bis != null) bis.close();
                            if (os != null) os.close();
                        }
                        break;
                    }
                }
            }
            } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        //System.out.println("Closing connection");
// close connection
            //socket.close();
            //input.close();
    }
    public static void main(String args[]){
        Server server = new Server(5000);
    }
}
