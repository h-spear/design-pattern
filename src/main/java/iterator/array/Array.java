package iterator.array;

import iterator.Aggregator;
import iterator.Element;
import iterator.Iterator;

public class Array implements Aggregator {

    private Element[] elements;

    public Array(Element[] elements) {
        this.elements = elements;
    }

    public Element getItem(int index) {
        return elements[index];
    }

    public int getCount() {
        return elements.length;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator(this);
    }
}
