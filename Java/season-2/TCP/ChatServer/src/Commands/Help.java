package Commands;

import ClientHandler.ClientHandler;

import java.io.IOException;

public class Help extends CommandAbstract {

    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Available commands: /help, /whisper, /quit, /list, /changeColor, /changeName \n"));
        clientHandler.getOut().flush();
    }
}
