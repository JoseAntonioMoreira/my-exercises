import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//https://www.canva.com/design/DAGU_7dt7dk/1AbJAeJ9m_aBNx-f_COuQw/edit
public class Client {
    String hostName = "localhost";
    int portNumber = 50000;

    Socket clientSocket;

    OutputStream out;
    BufferedReader in;

    private ExecutorService readingServerExecutor;

    public Client() throws IOException {
        clientSocket = new Socket(hostName, portNumber);

        out = clientSocket.getOutputStream();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        readingServerExecutor = Executors.newSingleThreadExecutor();
    }

    public void sendInfo() throws IOException {
        Scanner scanner = new Scanner(System.in);


        readingServerExecutor.submit(() -> {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });


        while (true) {
            String input = scanner.nextLine();
            out.write((input + "\n").getBytes());
        }
    }
}
