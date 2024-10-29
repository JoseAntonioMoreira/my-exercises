import java.io.BufferedReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final int port = 60001;
    private Socket socket;
    private ServerSocket serverSocket;

    public Server() throws IOException {
        serverSocket = new ServerSocket(port);
        socket = serverSocket.accept();

        new Thread(new ClientHandler(socket)).start();

    }
}
