import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    ExecutorService fixedPool = Executors.newFixedThreadPool(5);
    public static LinkedList<ClientHandler> clientHandlers;

    public Server() throws IOException {
        clientHandlers = new LinkedList<>();
        ServerSocket serverSocket = new ServerSocket(50000);
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler temp = new ClientHandler(socket);
            clientHandlers.add(temp);
            fixedPool.submit(temp);
        }
    }
}
