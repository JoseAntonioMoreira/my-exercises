public class App {
    public static final String STRING = "rui rui rui campelo campelo campelo test abc abc";
    public static void main(String[] args) throws Exception {
        UniqueWord wc = new UniqueWord(STRING);

        for(String word: wc){
            System.out.println(word);
        }
    }
}
