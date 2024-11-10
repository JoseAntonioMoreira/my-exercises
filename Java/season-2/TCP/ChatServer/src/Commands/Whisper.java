package Commands;

import ClientHandler.ClientHandler;
import Server.Server;

import java.io.IOException;

public class Whisper extends DefaultCommand {
    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "To whom belongs this secret : \n"));
        clientHandler.getOut().flush();
        String nick = clientHandler.getIn().readLine();
        for (ClientHandler client : Server.clientHandlers) {
            if (client.getNick().equals(nick)) {

                clientHandler.getOut().write((clientHandler.getUsedColor() + "What secret you wanna tell : \n"));
                clientHandler.getOut().flush();

                client.getOut().write((clientHandler.getUsedColor() + clientHandler.getNick() +
                        " whisper:" + clientHandler.getIn().readLine() + client.getUsedColor() + "\n"));
                clientHandler.getOut().flush();
                client.getOut().flush();

                return;
            }
        }

        clientHandler.getOut().write((clientHandler.getUsedColor() + nick + " is not online \n"));
        clientHandler.getOut().flush();
    }
}
