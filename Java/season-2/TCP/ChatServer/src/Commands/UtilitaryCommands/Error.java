package Commands.UtilitaryCommands;

import ClientHandler.ClientHandler;
import Commands.CommandAbstract;

import java.io.IOException;

public class Error extends CommandAbstract {

    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write("Unknown command \n");
        clientHandler.getOut().flush();
    }
}
