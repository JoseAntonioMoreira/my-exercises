import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramComp extends HashMap<String, Integer> implements Iterable<String> {
    String[] splitWords;

    public WordHistogramComp(String phrase) {
        splitWords = phrase.split(" ");

        for (String splitWord : splitWords) {
            this.merge(splitWord, 1, Integer::sum);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return this.keySet().iterator();
    }
}




/*
import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramComp implements Iterable<String> {

    String[] splitWords;
    HashMap<String, Integer> wordMaps = new HashMap<>();

    public WordHistogramComp(String phrase) {
        splitWords = phrase.split(" ");

        for (String splitWord : splitWords) {
            wordMaps.merge(splitWord, 1, Integer::sum);
        }
    }

    @Override
    public Iterator<String> iterator() {
        return wordMaps.keySet().iterator();
    }

    public int size() {
        return wordMaps.size();
    }

    public int get(String word) {
        return wordMaps.get(word);
    }
}
*/
