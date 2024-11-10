package Commands;

import ClientHandler.ClientHandler;
import Server.Server;

import java.io.IOException;

public class ListUsers extends DefaultCommand {
    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "There are currently " + Server.clientHandlers.size() + " users online: \n"));
        for (ClientHandler client : Server.clientHandlers) {
            clientHandler.getOut().write((client.getUsedColor() + client.getNick() + "\n"));
        }
        clientHandler.getOut().flush();
    }
}
