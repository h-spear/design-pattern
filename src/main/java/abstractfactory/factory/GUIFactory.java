package abstractfactory.factory;

import abstractfactory.product.Button;
import abstractfactory.product.Checkbox;
import abstractfactory.product.TextEdit;

/**
 * Abstract Factory
 */
public interface GUIFactory {
    Button createButton(String caption);
    Checkbox createCheckbox(boolean checked);
    TextEdit createTextEdit(String value);
}
