import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Map;

public class ClientHandler implements Runnable {
    private String usedColor = Colors.WHITE.getColor();
    private String nick;
    private final Socket socket;
    private BufferedReader in;
    private OutputStream out;

    public String getNick() {
        return nick;
    }

    public void setNick(String newNick) {
        nick = newNick;
    }

    public OutputStream getOut() {
        return out;
    }

    public String getUsedColor() {
        return usedColor;
    }

    public void setUsedColor(String newColor) {
        usedColor = newColor;
    }

    public BufferedReader getIn() {
        return in;
    }

    public Socket getSocket() {
        return socket;
    }

    public ClientHandler(Socket socket) {
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
        setupAccount();

        while (true) {
            String request = in.readLine();
            if (!request.startsWith("/")) {
                Commands.sayMessage(this, request);
            } else {
                switch (request) {
                    case "/help":
                        Commands.help(this);
                        break;
                    case "/whisper":
                        Commands.whisper(this);
                        break;
                    case "/list":
                        Commands.listUsers(this);
                        break;
                    case "/changeColor":
                        Commands.changeColor(this);
                        break;
                    case "/changeName":
                        Commands.changeName(this);
                        break;
                    case "/quit":
                        disconnect();
                        return;
                    default:
                        Commands.error(this);
                        break;
                }
            }
        }
    }

    private void setupAccount() throws IOException {
        out.write("write your nick: \n".getBytes());

        Commands.confirmUniqueName(this);

        Server.clientHandlers.add(this);
        Commands.sayMessage(this, nick + " has arrived !");
        out.write(("Welcome " + nick + " what would you like to do ? \n").getBytes());
    }

    public void disconnect() throws IOException {
        out.write((getUsedColor() + "See you soon ! \n").getBytes());
        out.close();
        in.close();
        getSocket().close();
        Server.clientHandlers.remove(this);
        Commands.sayMessage(this, getUsedColor() + "Good bye everyone !");
    }


}
