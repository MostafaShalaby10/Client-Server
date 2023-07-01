package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String[] args) throws IOException {
        //Receive the message
        ServerSocket serverSocket = new ServerSocket(5555);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String text = dataInputStream.readUTF();
        //Check the message
        if (text.equals("Bing") || text.equals("bing")) {
            System.out.println(text);
            //Send the message
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("Bong");
        } else {
            System.out.println("Error");
            System.out.println("...Closing connection");

        }
        dataInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
    }
}
