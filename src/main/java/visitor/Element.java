package visitor;

/**
 * Element
 *  - Composite Pattern
 */
public interface Element {
    void accept(Visitor visitor);
}
