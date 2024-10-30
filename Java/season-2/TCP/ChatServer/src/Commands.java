import java.io.IOException;

public class Commands {

    public static void sayMessage(ClientHandler clientHandler, String message) throws IOException {
        for (ClientHandler client : Server.clientHandlers) {
            if (clientHandler == client) {
                continue;
            }
            clientHandler.getOut().write((clientHandler.getUsedColor() + clientHandler.getNick() + ": " + message
                    + clientHandler.getUsedColor() + "\n").getBytes());
        }
    }

    public static void whisper(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "To whom belongs this secret : \n").getBytes());
        String nick = clientHandler.getIn().readLine();
        for (ClientHandler client : Server.clientHandlers) {
            if (client.getNick().equals(nick)) {
                clientHandler.getOut().write((clientHandler.getUsedColor() + "What secret you wanna tell : \n").getBytes());
                client.getOut().write((clientHandler.getUsedColor() + clientHandler.getNick() + " whisper:" + clientHandler.getIn().readLine() + client.getUsedColor() + "\n").getBytes());
                return;
            }
        }
        clientHandler.getOut().write((clientHandler.getUsedColor() + nick + " is not online \n").getBytes());
    }

    public static void help(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Available commands: /help, /whisper, /quit, /list, /changeColor, /changeName \n").getBytes());
    }

    public static void listUsers(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "There are currently " + Server.clientHandlers.size() + " users online: \n").getBytes());
        for (ClientHandler client : Server.clientHandlers) {
            clientHandler.getOut().write((client.getUsedColor() + client.getNick() + "\n").getBytes());
        }
    }

    public static void changeColor(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Available colors: RED, GREEN, YELLOW, BLUE, WHITE \n").getBytes());
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Color name: \n").getBytes());
        Colors color = Colors.valueOf(clientHandler.getIn().readLine().toUpperCase());
        clientHandler.setUsedColor(color.getColor());
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Color changed ! \n").getBytes());
    }

    public static void changeName(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Write new name: \n").getBytes());
        String oldNick = clientHandler.getNick();
        confirmUniqueName(clientHandler);
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Name changed to " + clientHandler.getNick() + "! \n").getBytes());
        sayMessage(clientHandler, clientHandler.getUsedColor() + oldNick + " has changed it's nick to " + clientHandler.getNick());
    }

    public static void error(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write("Unknown command \n".getBytes());
    }

    public static void confirmUniqueName(ClientHandler clientHandler) throws IOException {
        while (true) {
            boolean isUnique = true;
            clientHandler.setNick(clientHandler.getIn().readLine());

            for (ClientHandler client : Server.clientHandlers) {
                if (client.getNick().equals(clientHandler.getNick()) && clientHandler != client) {
                    clientHandler.getOut().write((clientHandler.getUsedColor() + "That nick is already in use \n").getBytes());
                    isUnique = false;
                }
            }

            if (isUnique) {
                break;
            }
        }
    }
}
