import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";

        String kek = Stream.of(message.split(" "))
                .filter(s -> !s.equals("garbage"))
                .map(String::toUpperCase)
                .reduce("",(phrase, element) -> phrase + element + " ");
        System.out.println(kek);
    }
}
