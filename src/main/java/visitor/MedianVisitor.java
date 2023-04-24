package visitor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MedianVisitor implements Visitor {

    List<Item> list = new ArrayList<>();

    public double getValue() {
        list.sort(Comparator.comparingInt(Item::getValue));
        int length = list.size();
        if ((length & 1) == 0) {
            return getAverage(list.get(length / 2 - 1).getValue(), list.get(length / 2).getValue());
        } else {
            return list.get(length / 2).getValue();
        }
    }

    @Override
    public void visit(Element element) {
        if (element instanceof Item) {
            list.add((Item) element);
        } else {
            element.accept(this);
        }
    }

    private double getAverage(int a, int b) {
        return (double) (a + b) / 2;
    }

    public void init() {
        list.clear();
    }
}
