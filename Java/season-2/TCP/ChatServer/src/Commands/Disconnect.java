package Commands;

import ClientHandler.ClientHandler;
import Server.Server;

import java.io.IOException;

public class Disconnect extends CommandAbstract {

    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "See you soon ! \n"));
        clientHandler.getOut().flush();
        clientHandler.getOut().close();
        clientHandler.getIn().close();
        clientHandler.getSocket().close();
        Server.broadcast(clientHandler, clientHandler.getUsedColor() + "Good bye everyone !");
        Server.clientHandlers.remove(clientHandler);
        clientHandler.getOut().flush();
    }
}
