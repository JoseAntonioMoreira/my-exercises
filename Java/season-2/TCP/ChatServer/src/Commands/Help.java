package Commands;

import ClientHandler.ClientHandler;

import java.io.IOException;

public class Help extends DefaultCommand {

    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Available commands: /help, /whisper, /quit, /list, /changeColor, /changeName \n"));
        clientHandler.getOut().flush();
    }
}
