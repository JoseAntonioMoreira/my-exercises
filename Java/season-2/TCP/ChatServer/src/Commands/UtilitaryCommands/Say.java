package Commands.UtilitaryCommands;

import ClientHandler.ClientHandler;

import java.io.IOException;

public class Say {

    public void execute(ClientHandler clientHandler, String message, ClientHandler sender) throws IOException {

        clientHandler.getOut().write((clientHandler.getUsedColor() + sender.getNick() + ": " + message
                + clientHandler.getUsedColor() + "\n"));
        clientHandler.getOut().flush();
    }
}
