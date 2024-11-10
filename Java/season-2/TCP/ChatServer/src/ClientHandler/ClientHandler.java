package ClientHandler;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import Colors.Colors;
import Commands.*;
import Commands.UtilitaryCommands.ConfirmUniqueName;
import Commands.UtilitaryCommands.Say;
import Server.Server;


public class ClientHandler implements Runnable {
    private final Socket socket;
    private final Map<String, DefaultCommand> commandMap;

    private final ConfirmUniqueName confirmUniqueName;
    private String usedColor = Colors.WHITE.getColor();

    private String nick;
    private BufferedReader in;
    private BufferedWriter out;


    public String getNick() {
        return nick;
    }

    public void setNick(String newNick) {
        nick = newNick;
    }

    public String getUsedColor() {
        return usedColor;
    }

    public void setUsedColor(String newColor) {
        usedColor = newColor;
    }

    public BufferedWriter getOut() {
        return out;
    }

    public BufferedReader getIn() {
        return in;
    }

    public Socket getSocket() {
        return socket;
    }

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;

        commandMap = new HashMap<>();
        confirmUniqueName = new ConfirmUniqueName();

        setupCommandMap();
    }

    public void setupCommandMap() throws IOException {
        commandMap.put("/help", new Help());
        commandMap.put("/whisper", new Whisper());
        commandMap.put("/list", new ListUsers());
        commandMap.put("/changeColor", new ChangeColor());
        commandMap.put("/changeName", new ChangeName(confirmUniqueName));
        commandMap.put("/quit", new Disconnect());
    }

    @Override
    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            handler();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handler() throws IOException {
        setupAccount();

        while (true) {
            String request = in.readLine();
            if (!request.startsWith("/")) {
                Server.broadcast(this, request);
            } else if (commandMap.containsKey(request)) {
                commandMap.get(request).execute(this);
            } else {
                new DefaultCommand().execute(this);
            }
        }
    }

    private void setupAccount() throws IOException {
        out.write("write your nick: \n");
        out.flush();

        confirmUniqueName.execute(this);

        Server.clientHandlers.add(this);

        Server.broadcast(this, nick + " has arrived !");
        out.write(("Welcome " + nick + " what would you like to do ? \n"));
        out.flush();
    }
}
