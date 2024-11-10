package Commands;

import ClientHandler.ClientHandler;
import Commands.UtilitaryCommands.ConfirmUniqueName;
import Server.Server;

import java.io.IOException;

public class ChangeName extends DefaultCommand {

    ConfirmUniqueName confirmUniqueName;

    public ChangeName(ConfirmUniqueName confirmUniqueName) {
        this.confirmUniqueName = confirmUniqueName;
    }

    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Write new name: \n"));
        clientHandler.getOut().flush();

        String oldNick = clientHandler.getNick();
        confirmUniqueName.execute(clientHandler);
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Name changed to " + clientHandler.getNick() + "! \n"));
        clientHandler.getOut().flush();
        Server.broadcast(clientHandler, clientHandler.getUsedColor() + oldNick + " has changed it's nick to " + clientHandler.getNick());
    }
}
