public class Main {
    public static void main(String[] args) {
        try {
            new Client().sendInfo();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}