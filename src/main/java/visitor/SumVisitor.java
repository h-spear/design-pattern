package visitor;

/**
 * ConcreteVisitor
 */
public class SumVisitor implements Visitor {

    private int sum = 0;

    public int getValue() {
        return sum;
    }

    @Override
    public void visit(Element element) {
        if (element instanceof Item) {
            sum += ((Item) element).getValue();
        } else {
            element.accept(this);
        }
    }

    public void init() {
        sum = 0;
    }
}
