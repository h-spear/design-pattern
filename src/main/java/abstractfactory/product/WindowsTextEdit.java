package abstractfactory.product;

public class WindowsTextEdit extends TextEdit {

    public WindowsTextEdit(String value) {
        super(value);
    }

    @Override
    public void render() {
        System.out.println("Draw text edit with '" + this.value + "' value using Windows rendering API.");
    }
}
