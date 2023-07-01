package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class receiver {
    public static void main(String[] args) throws IOException {
        //Receive the message
        DatagramSocket datagramSocket = new DatagramSocket(6666);
        byte[]  bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes , bytes.length);
        datagramSocket.receive(datagramPacket);
        String text= new String(datagramPacket.getData(),0,datagramPacket.getLength());
        //Check the message
        if (text.equals("Bing") ||text.equals("bing") )
        {
            System.out.println(text);
            //Send the message
            String text1 = "Bong"  ;
            InetAddress ip = InetAddress.getByName("127.0.0.1");
            DatagramPacket datagramPacket1 = new DatagramPacket(text1.getBytes(), text1.length(), ip, 7777);
            datagramSocket.send(datagramPacket1);
        }else
        {
            System.out.println("Error");
            System.out.println("...Closing connection");
        }
        datagramSocket.close();
    }
}
