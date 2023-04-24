package visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ConcreteElement
 */
public class ItemList implements Element {
    private List<Element> list = new ArrayList<>();

    public void add(Element element) {
        list.add(element);
    }

    @Override
    public void accept(Visitor visitor) {
        Iterator<Element> it = list.iterator();

        while (it.hasNext()) {
            visitor.visit(it.next());
        }
    }
}
