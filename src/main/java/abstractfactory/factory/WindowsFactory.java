package abstractfactory.factory;


import abstractfactory.product.*;

public class WindowsFactory implements GUIFactory {

    @Override
    public Button createButton(String caption) {
        return new WindowsButton(caption);
    }

    @Override
    public Checkbox createCheckbox(boolean checked) {
        return new WindowsCheckbox(checked);
    }

    @Override
    public TextEdit createTextEdit(String value) {
        return new WindowsTextEdit(value);
    }
}
