import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {

    private String nick;
    private final Socket socket;
    private BufferedReader in;
    private OutputStream out;

    public String getNick() {
        return nick;
    }

    public OutputStream getOut() {
        return out;
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
                sayMessage(request);
            } else {
                switch (request) {
                    case "/help":
                        help();
                        break;
                    case "/whisper":
                        whisper();
                        break;
                    case "/quit":
                        disconnect();
                        return;
                    case "/list":
                        listUsers();
                        break;
                    case "/changeColor":
                        changeColor();
                        break;
                    case "/changeName":
                        changeName();
                        break;
                    default:
                        error();
                        break;
                }
            }
        }
    }

    private void setupAccount() throws IOException {
        out.write("write your nick: \n".getBytes());

        confirmUniqueName();

        sayMessage(nick + " has arrived !");
        out.write(("Welcome " + nick + " what would you like to do ? \n").getBytes());
    }

    private void sayMessage(String message) throws IOException {
        for (ClientHandler clientHandler : Server.clientHandlers) {
            if(clientHandler == this){
                continue;
            }
            clientHandler.getOut().write((nick + ": " + message + "\n").getBytes());
        }
    }

    private void whisper() throws IOException {
        out.write("To whom belongs this secret : \n".getBytes());
        String nick = in.readLine();
        for (ClientHandler clientHandler : Server.clientHandlers) {
            if (clientHandler.getNick().equals(nick)) {
                out.write("What secret you wanna tell : \n".getBytes());
                clientHandler.getOut().write((this.nick + " whisper:" + in.readLine() + "\n").getBytes());
                return;
            }
        }
        out.write((nick + " is not online \n").getBytes());
    }

    private void disconnect() throws IOException {
        out.write("See you soon ! \n".getBytes());
        out.close();
        in.close();
        socket.close();
        Server.clientHandlers.remove(this);
        sayMessage("Good bye everyone !");
    }

    private void help() throws IOException {
        out.write("Available commands: /help, /whisper, /quit, /list, /changeColor, /changeName \n".getBytes());
    }

    private void listUsers() throws IOException {
        out.write(("There are currently " + Server.clientHandlers.size() + " users online: \n").getBytes());
        for (ClientHandler clientHandler : Server.clientHandlers) {
            out.write((clientHandler.getNick() + "\n").getBytes());
        }
    }

    private void changeColor() {

    }

    private void changeName() throws IOException {
        out.write("Write new name: \n".getBytes());
        String oldNick = nick;
        confirmUniqueName();
        out.write(("Name changed to " + nick + "! \n").getBytes());
        sayMessage(oldNick + " has changed it's nick to " + nick);
    }

    private void error() throws IOException {
        out.write("Unknown command \n".getBytes());
    }

    private void confirmUniqueName() throws IOException {
        while (true){
            boolean isUnique = true;
            nick = in.readLine();

            for (ClientHandler clientHandler : Server.clientHandlers){
                if(clientHandler.getNick().equals(nick) && clientHandler != this){
                    out.write("That nick is already in use \n".getBytes());
                    isUnique = false;
                }
            }

            if(isUnique){
                break;
            }
        }
    }
}
