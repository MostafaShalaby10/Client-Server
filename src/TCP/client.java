package TCP;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;


public class client {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //Enter the message
        System.out.println("Please Enter the word!!");
        String msg = scanner.next();
        Socket socket = new Socket("localhost", 5555);
        //Send the message
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF(msg);
        //Receive the message
        String text = dataInputStream.readUTF();
        System.out.println(text);
        dataOutputStream.close();
        outputStream.close();
        socket.close();
    }
}

