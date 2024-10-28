import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClientHandler implements Runnable {
    final String TEXTHEADER = "text/html; charset=UTF-8\\r\\n";
    final String IMAGEHEADER = "image/<image_file_extension> \\r\\n\"";
    final String OKHEADER = "HTTP/1.0 200 Document Follows\\r\\n";
    final String ERRORHEADER = "HTTP/1.0 404 Not Found";


    Socket socket;
    OutputStream out;
    BufferedReader in;
    String request;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            out = socket.getOutputStream();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            handleRequest();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void handleRequest() throws IOException {
        request = in.readLine();
        switch (request) {
            case "GET / HTTP/1.1", "GET /index.html HTTP/1.1":
                sendRequest(getHTML("www/index.html"), OKHEADER, TEXTHEADER);
                break;
            case "GET /favicon.ico HTTP/1.1":
                sendRequest(getImage("www/favicon.ico"), OKHEADER, IMAGEHEADER);
                break;
            case "GET /logo.png HTTP/1.1":
                sendRequest(getImage("www/logo.png"), OKHEADER, IMAGEHEADER);
                break;
            default:
                sendRequest(getHTML("www/404.html"), ERRORHEADER, TEXTHEADER);
                break;
        }
    }

    private byte[] getHTML(String path) throws IOException {
        Path fileName = Path.of(path);
        return Files.readString(fileName).getBytes();
    }

    private byte[] getImage(String path) throws IOException {
        Path filePath = Path.of(path);
        return Files.readAllBytes(filePath);
    }

    private void sendRequest(byte[] content, String headerCode, String headerType) throws IOException {
        //header
        out.write(headerCode.getBytes());
        out.write(headerType.getBytes());
        out.write(("Content-Length: " + content.length + "\r\n").getBytes());
        out.write("\r\n".getBytes());

        out.write(content);

        out.flush();

        disconnect();
    }

    private void disconnect() throws IOException {
        out.close();
        in.close();
        socket.close();
    }
}
