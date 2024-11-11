import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringInputScanner;

public class Main {
    public static void main(String[] args) {
        String login = "Jo";
        String pass = "Ok1";
        Prompt prompt = new Prompt(System.in,System.out);
        System.out.println("Welcome to your first Prompt-View Experience");
        System.out.println();
        System.out.println("Insert your login credentials below:");
        StringInputScanner username = new StringInputScanner();
        username.setMessage("Username:");
        username.setError("Invalid name");
        PasswordInputScanner password = new PasswordInputScanner();
        password.setMessage("Password:");
        password.setError("Invalid Password");

        String user = prompt.getUserInput(username);
        String senha = prompt.getUserInput(password);

        if(login.equals(user) && pass.equals(senha)){
            System.out.println();
            System.out.println("Login successfull !");
            System.out.println("Welcome home, " + user);
        }

    }
}
