package abstractfactory.product;

public class WindowsCheckbox extends Checkbox {

    public WindowsCheckbox(boolean checked) {
        super(checked);
    }

    @Override
    public void render() {
        System.out.println("Draw " + (this.checked ? "'checked'" : "'unchecked'") + " checkbox using Windows rendering API.");
    }
}
