package visitor;

/**
 * ConcreteVisitor
 */
public class AverageVisitor implements Visitor {
    private int sum = 0;
    private int count = 0;

    public double getValue() {
        return (double) sum / count;
    }

    @Override
    public void visit(Element element) {
        if (element instanceof Item) {
            sum += ((Item) element).getValue();
            count++;
        } else {
            element.accept(this);
        }
    }

    public void init() {
        sum = 0;
        count = 0;
    }
}
