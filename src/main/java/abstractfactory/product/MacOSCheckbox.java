package abstractfactory.product;

public class MacOSCheckbox extends Checkbox {

    public MacOSCheckbox(boolean checked) {
        super(checked);
    }

    @Override
    public void render() {
        System.out.println("Draw " + (this.checked ? "'checked'" : "'unchecked'") + " checkbox using Mac OS rendering API.");
    }
}
