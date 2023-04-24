package visitor;

/**
 * ConcreteElement
 */
public class Item implements Element {
    private int value;

    public Item(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
