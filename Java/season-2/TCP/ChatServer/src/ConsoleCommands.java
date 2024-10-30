import java.io.IOException;

enum ConsoleCommands {
    HELP {
        void help(ClientHandler clientHandler) throws IOException {
            clientHandler.getOut().write((clientHandler.getUsedColor() + "Available commands: /help, /whisper, /quit, /list, /changeColor, /changeName \n").getBytes());
        }
    },
    QUIT {
        public void disconnect(ClientHandler clientHandler) throws IOException {
            clientHandler.getOut().write((clientHandler.getUsedColor() + "See you soon ! \n").getBytes());
            clientHandler.getOut().close();
            clientHandler.getIn().close();
            clientHandler.getSocket().close();
            Server.clientHandlers.remove(clientHandler);
            Commands.sayMessage(clientHandler, clientHandler.getUsedColor() + "Good bye everyone !");
        }
    },
    LIST {
        void listUsers(ClientHandler clientHandler) throws IOException {
            clientHandler.getOut().write((clientHandler.getUsedColor() + "There are currently " + Server.clientHandlers.size() + " users online: \n").getBytes());
            for (ClientHandler client : Server.clientHandlers) {
                clientHandler.getOut().write((client.getUsedColor() + client.getNick() + "\n").getBytes());
            }
        }
    },
    CHANGECOLOR {
        void changeColor(ClientHandler clientHandler) throws IOException {
            clientHandler.getOut().write((clientHandler.getUsedColor() + "Available colors: RED, GREEN, YELLOW, BLUE, WHITE \n").getBytes());
            clientHandler.getOut().write((clientHandler.getUsedColor() + "Color name: \n").getBytes());
            Colors color = Colors.valueOf(clientHandler.getIn().readLine().toUpperCase());
            clientHandler.setUsedColor(color.getColor());
            clientHandler.getOut().write((clientHandler.getUsedColor() + "Color changed ! \n").getBytes());
        }

    },
    CHANGENAME {
        void changeName(ClientHandler clientHandler) throws IOException {
            clientHandler.getOut().write((clientHandler.getUsedColor() + "Write new name: \n").getBytes());
            String oldNick = clientHandler.getNick();
            //confirmUniqueName(clientHandler);
            clientHandler.getOut().write((clientHandler.getUsedColor() + "Name changed to " + clientHandler.getNick() + "! \n").getBytes());
            //ConsoleCommands.MESSAGE.sayMessage(clientHandler, clientHandler.getUsedColor() + oldNick + " has changed it's nick to " + clientHandler.getNick());
        }

    },

    ERROR {
        void error(ClientHandler clientHandler) throws IOException {
            clientHandler.getOut().write("Unknown command \n".getBytes());
        }
    };
}
