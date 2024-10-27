public class Main {
    public static void main(String[] args) {
        try {
            while (true){
                new Server().handleRequest();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
