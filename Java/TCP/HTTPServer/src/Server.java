import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class Server {

    String hostName = "localhost";
    int serverPort = 60000;
    ServerSocket serverSocket;
    Socket socket;
    OutputStream out;
    BufferedReader in;

    public Server() throws IOException {
        serverSocket = new ServerSocket(serverPort);
        socket = serverSocket.accept();
        out = socket.getOutputStream();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    String httpStart = "HTTP/1.1 200\r\n";
    String httpType = "Content-Type: text/html; charset=UTF-8\r\n";
    String httpLength;
    String httpEnd = "\r\n";

    public void sendIndex() throws IOException {
        System.out.println(in.readLine());
        Path fileName = Path.of("www/index.html");
        String content = Files.readString(fileName);
        //System.out.println(content);
        out.write(httpStart.getBytes());
        out.write(httpType.getBytes());
        httpLength = httpLength = "Content-Length: " + content.getBytes().length  + "\r\n";
        out.write(httpLength.getBytes());
        out.write(httpEnd.getBytes());
        out.write(content.getBytes());
        out.flush();
    }
}
