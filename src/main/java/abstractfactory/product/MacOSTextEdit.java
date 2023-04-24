package abstractfactory.product;

public class MacOSTextEdit extends TextEdit {

    public MacOSTextEdit(String value) {
        super(value);
    }

    @Override
    public void render() {
        System.out.println("Draw text edit with '" + this.value + "' value using Mac OS rendering API.");
    }
}
