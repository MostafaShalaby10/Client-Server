package UDP;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class sender {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //Enter the message
        System.out.println("Please Enter the word!!");
        String msg = scanner.next();
        //Send the message
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), msg.length(), ip, 6666);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
//Receive the message
        DatagramSocket datagramSocket1 = new DatagramSocket(7777);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length);
        datagramSocket1.receive(datagramPacket1);
        String text1 = new String(datagramPacket1.getData(), 0, datagramPacket1.getLength());
        System.out.println(text1);
        datagramSocket1.close();


    }
}
