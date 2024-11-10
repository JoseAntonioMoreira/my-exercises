package Commands;

import ClientHandler.ClientHandler;

import java.io.IOException;

public abstract class CommandAbstract {
    public abstract void execute(ClientHandler clientHandler) throws IOException;
}
