import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    //private final String RESET = "\u001B[0m";
    private final String RED = "\u001B[31m";
    private final String GREEN = "\u001B[32m";
    private final String YELLOW = "\u001B[33m";
    private final String BLUE = "\u001B[34m";
    private final String WHITE = "\u001B[37m";

    private String usedColor = WHITE;
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

    public String getUsedColor(){return usedColor;}

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
            if (clientHandler == this) {
                continue;
            }
            clientHandler.getOut().write((getUsedColor() + nick + ": " + message
                    + clientHandler.getUsedColor() + "\n").getBytes());
        }
    }

    private void whisper() throws IOException {
        out.write((usedColor + "To whom belongs this secret : \n" + WHITE).getBytes());
        String nick = in.readLine();
        for (ClientHandler clientHandler : Server.clientHandlers) {
            if (clientHandler.getNick().equals(nick)) {
                out.write((usedColor + "What secret you wanna tell : \n" + WHITE).getBytes());
                clientHandler.getOut().write((usedColor + this.nick + " whisper:" + in.readLine() + clientHandler.getUsedColor() + "\n").getBytes());
                return;
            }
        }
        out.write((usedColor + nick + " is not online \n" + WHITE).getBytes());
    }

    private void disconnect() throws IOException {
        out.write((usedColor + "See you soon ! \n").getBytes());
        out.close();
        in.close();
        socket.close();
        Server.clientHandlers.remove(this);
        sayMessage(usedColor + "Good bye everyone !" + WHITE);
    }

    private void help() throws IOException {
        out.write((usedColor + "Available commands: /help, /whisper, /quit, /list, /changeColor, /changeName \n").getBytes());
    }

    private void listUsers() throws IOException {
        out.write((usedColor + "There are currently " + Server.clientHandlers.size() + " users online: \n" + WHITE).getBytes());
        for (ClientHandler clientHandler : Server.clientHandlers) {
            out.write((usedColor + clientHandler.getNick() + "\n" + WHITE).getBytes());
        }
    }

    private void changeColor() throws IOException {
        out.write((usedColor + "Available colors: RED, GREEN, YELLOW, BLUE, WHITE \n" + WHITE).getBytes());
        out.write((usedColor + "Color name: \n" + WHITE).getBytes());
        usedColor = in.readLine();
        switch (usedColor) {
            case "RED":
                usedColor = RED;
                break;
            case "GREEN":
                usedColor = GREEN;
                break;
            case "YELLOW":
                usedColor = YELLOW;
                break;
            case "BLUE":
                usedColor = BLUE;
                break;
            case "WHITE":
                usedColor = WHITE;
                break;
        }
        out.write((usedColor + "Color changed ! \n" + WHITE).getBytes());
    }

    private void changeName() throws IOException {
        out.write((usedColor + "Write new name: \n" + WHITE).getBytes());
        String oldNick = nick;
        confirmUniqueName();
        out.write((usedColor + "Name changed to " + nick + "! \n" + WHITE).getBytes());
        sayMessage(usedColor + oldNick + " has changed it's nick to " + nick + WHITE);
    }

    private void error() throws IOException {
        out.write("Unknown command \n".getBytes());
    }

    private void confirmUniqueName() throws IOException {
        while (true) {
            boolean isUnique = true;
            nick = in.readLine();

            for (ClientHandler clientHandler : Server.clientHandlers) {
                if (clientHandler.getNick().equals(nick) && clientHandler != this) {
                    out.write((usedColor + "That nick is already in use \n" + WHITE).getBytes());
                    isUnique = false;
                }
            }

            if (isUnique) {
                break;
            }
        }
    }
}
