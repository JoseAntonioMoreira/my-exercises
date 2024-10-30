import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    ExecutorService fixedPool = Executors.newFixedThreadPool(50);
    public final static List<ClientHandler> clientHandlers = Collections.synchronizedList(new LinkedList<>());

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(50000);
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler temp = new ClientHandler(socket);
            clientHandlers.add(temp);
            fixedPool.submit(temp);
        }
    }
}
