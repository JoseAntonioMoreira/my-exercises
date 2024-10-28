import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class Client {

    String hostName = "localhost";
    int portNumber = 50000;

    // STEP2: Open a client socket, blocking while connecting to the server
    Socket clientSocket;

    // STEP3: Setup input and output streams
    PrintWriter out;
    BufferedReader in;

    public Client(String message) throws IOException {
        clientSocket = new Socket(hostName, portNumber);

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println(message);
        System.out.println(in.readLine());
    }
}
