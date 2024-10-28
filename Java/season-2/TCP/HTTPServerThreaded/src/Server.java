import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class Server {
    String hostName = "localhost";
    int serverPort = 60000;
    ServerSocket serverSocket;
    Socket socket;


    public Server() throws IOException {
        serverSocket = new ServerSocket(serverPort);

        while (true){
            socket = serverSocket.accept();
            new Thread(new ClientHandler(socket)).start();
        }
    }

}
