import java.util.Iterator;

public class RangeIterator implements Iterator<Integer> {

    private Range range;

    public RangeIterator(Range range) {
        this.range = range;
    }

    @Override
    public boolean hasNext() {
        return !(range.getCurrent() > range.getMax());
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            range.setCurrent(range.getCurrent() + 1);
            return range.getCurrent();
        }
        return null;
    }

    @Override
    public void remove() {

    }

}
