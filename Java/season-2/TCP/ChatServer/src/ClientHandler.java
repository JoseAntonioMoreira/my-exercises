import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable{

    private String nick;
    private Socket socket;
    private BufferedReader in;
    private OutputStream out;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = socket.getOutputStream();
            handler();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handler() throws IOException {
        out.write("write your nick: ".getBytes());
        nick = in.readLine();
        out.write(("Welcome " + nick + " what would you like to do ?").getBytes());
        String request = in.readLine();
        System.out.println(request);
    }
}
