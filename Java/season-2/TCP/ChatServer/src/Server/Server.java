package Server;

import ClientHandler.ClientHandler;
import Commands.UtilitaryCommands.Say;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    ExecutorService fixedPool = Executors.newFixedThreadPool(5);
    public final static List<ClientHandler> clientHandlers = Collections.synchronizedList(new LinkedList<>());

    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(50000);
        while (true) {
            Socket socket = serverSocket.accept();
            fixedPool.submit(new ClientHandler(socket));
        }
    }

    public static void broadcast(ClientHandler clientHandler, String message) throws IOException {
        Say say = new Say();

        for (ClientHandler client : Server.clientHandlers) {
            if (clientHandler == client) {
                continue;
            }
            say.execute(client, message, clientHandler);
        }
    }
}
