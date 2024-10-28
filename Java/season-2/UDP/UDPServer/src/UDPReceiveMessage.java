import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;

public class UDPReceiveMessage {

    String hostName = "localhost";
    int localPort = 50000;

    InetAddress clientAddress;
    int clientPort;

    byte[] sendBuffer = new byte[1024];
    byte[] recvBuffer = new byte[1024];
    DatagramSocket socket;

    public UDPReceiveMessage() throws IOException {
        socket = new DatagramSocket(localPort);
        receiveMessage();
    }

    private void receiveMessage() throws IOException {
        DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
        socket.receive(receivePacket); // blocks while packet not received
        recvBuffer = receivePacket.getData();
        clientAddress = receivePacket.getAddress();
        clientPort = receivePacket.getPort();
        sendMessage();
    }

    private String upperCaseMessage() {
        String temp = new String(recvBuffer, StandardCharsets.UTF_8);
        temp = temp.replace("\0", "");
        temp = temp.toUpperCase();
        System.out.println(temp);
        return temp;
    }

    private void sendMessage() throws IOException {
        String temp = upperCaseMessage();
        sendBuffer = temp.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
        socket.send(sendPacket);
        socket.close();
    }


}
