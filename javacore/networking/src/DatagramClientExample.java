
import java.io.IOException;
import java.net.*;

public class DatagramClientExample {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();
        byte[] bytes = new byte[100];

        InetAddress address = InetAddress.getByName("localhost");
        bytes = "Client say Xin Chao".getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length,address,4445);
        socket.send(packet);

        DatagramPacket packet1 = new DatagramPacket(bytes, bytes.length);
        socket.receive(packet1);

        System.out.println("From Server: " + new String(packet.getData(), 0, packet.getLength()));
        socket.close();
    }
}
