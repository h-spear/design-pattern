package abstractfactory.factory;

import abstractfactory.product.*;

public class MacOSFactory implements GUIFactory {

    @Override
    public Button createButton(String caption) {
        return new MacOSButton(caption);
    }

    @Override
    public Checkbox createCheckbox(boolean checked) {
        return new MacOSCheckbox(checked);
    }

    @Override
    public TextEdit createTextEdit(String value) {
        return new MacOSTextEdit(value);
    }
}
