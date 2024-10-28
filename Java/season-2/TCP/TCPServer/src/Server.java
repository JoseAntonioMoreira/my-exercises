import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    int portNumber = 50000;

    ServerSocket serverSocket;
    Socket clientSocket;


    PrintWriter out;
    BufferedReader in;

    public Server() throws IOException {
        serverSocket = new ServerSocket(portNumber);
        System.out.println("Waiting for message...");
        clientSocket = serverSocket.accept();

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println(in.readLine());

        out.println("Message Received");
    }
}
