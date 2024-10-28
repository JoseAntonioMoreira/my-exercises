import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class Client {
    String hostName = "localhost";
    int localPort = 50001;

    int serverPort = 50000;

    byte[] sendBuffer = new byte[1024];
    byte[] recvBuffer = new byte[1024];
    DatagramSocket socket;

    public Client(String message) throws IOException {
        socket = new DatagramSocket(localPort);
        sendMessage(message);
        socket.close();
    }

    private void sendMessage(String message) throws IOException {
        sendBuffer = message.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, InetAddress.getByName(hostName), serverPort);
        socket.send(sendPacket);
        receiveMessage();
    }

    private void receiveMessage() throws IOException {
        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket); // blocks while packet not received
        recvBuffer = receivePacket.getData();
        System.out.println(new String(recvBuffer).replace("\0",""));
    }
}
