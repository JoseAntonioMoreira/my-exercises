public class Main {
    public static void main(String[] args) {
        try {
            new Server();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
