package Commands;

import ClientHandler.ClientHandler;

import java.io.IOException;

public class DefaultCommand {
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write("Unknown command \n");
        clientHandler.getOut().flush();
    }
}
