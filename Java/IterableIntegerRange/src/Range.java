import java.util.Iterator;

public class Range implements Iterable<Integer> {
    private int min;
    private int current;
    private int max;

    public Range(int min, int max) {
        this.min = min;
        this.current = min - 1;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new RangeIterator(this);
    }

    public int getCurrent() {
        return current;
    }

    public int getMax() {
        return max;
    }

    public void setCurrent(int nextCurrent) {
        current = nextCurrent;
    }

}
