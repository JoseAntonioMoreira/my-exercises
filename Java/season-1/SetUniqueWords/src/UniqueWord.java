import java.util.Iterator;
import java.util.TreeSet;

public class UniqueWord implements Iterable<String>{

    private TreeSet<String> stringSets;

    public UniqueWord(String string) {

        stringSets = new TreeSet<>();
        String[] temp = string.split(" ");
        for (int i = 0; i < temp.length; i++) {
            stringSets.add(temp[i]);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return stringSets.iterator();
    }

}
