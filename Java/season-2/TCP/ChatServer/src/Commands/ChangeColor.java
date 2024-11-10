package Commands;

import ClientHandler.ClientHandler;
import Colors.Colors;

import java.io.IOException;

public class ChangeColor extends CommandAbstract {
    @Override
    public void execute(ClientHandler clientHandler) throws IOException {
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Available colors: RED, GREEN, YELLOW, BLUE, WHITE \n"));
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Color name: \n"));
        clientHandler.getOut().flush();

        Colors color = Colors.valueOf(clientHandler.getIn().readLine().toUpperCase());

        clientHandler.setUsedColor(color.getColor());
        clientHandler.getOut().write((clientHandler.getUsedColor() + "Color changed ! \n"));
        clientHandler.getOut().flush();
    }
}
