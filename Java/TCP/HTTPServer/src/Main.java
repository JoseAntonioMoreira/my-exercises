public class Main {
    public static void main(String[] args) {
        try {
            new Server().sendIndex();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
