package Commands.UtilitaryCommands;

import ClientHandler.ClientHandler;
import Commands.CommandAbstract;
import Server.Server;

import java.io.IOException;

public class ConfirmUniqueName extends CommandAbstract {
    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        while (true) {
            boolean isUnique = true;
            clientHandler.setNick(clientHandler.getIn().readLine());

            for (ClientHandler client : Server.clientHandlers) {
                if (client.getNick().equals(clientHandler.getNick()) && clientHandler != client) {
                    clientHandler.getOut().write((clientHandler.getUsedColor() + "That nick is already in use \n"));
                    clientHandler.getOut().flush();
                    isUnique = false;
                }
            }

            if (isUnique) {
                break;
            }
        }
    }
}
