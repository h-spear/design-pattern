import abstractfactory.factory.GUIFactory;
import abstractfactory.factory.MacOSFactory;
import abstractfactory.factory.WindowsFactory;
import abstractfactory.product.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Abstract Factory : 제품 객체를 생성하기 위한 추상 팩토리를 정의
 * Concrete Factory : 구체적인 팩토리로, 구체적인 제품 객체들을 생성. Abstract Factory를 구현
 * Abstract Product : 팩토리에서 생성하는 제품 객체들의 공통 인터페이스
 * Concrete Product : 구체적인 제품 객체. Abstract Product를 구현
 *
 * 관련 객체들의 구상 클래스를 지정하지 않고도 관련 객체들의 모음을 생성할 수 있도록 하는 패턴
 * 객체 생성과 사용을 분리하여, 유연성과 확장성을 높일 수 있다.
 * **클라이언트 코드가 구체적인 클래스와 밀접하게 연결되어 있지 않으므로** 객체 생성 코드의 변경이 클라이언트에 영향을 주지 않는다.
 * 새로운 Product를 추가하는 것이 쉽다.
 * 객체 생성을 위한 코드가 복잡해질 수 있따.
 * 추상화된 인터페이스와 구체적인 클래스 간의 결합도가 높아진다.
 * 적절한 상황에 사용하지 않으면 오히려 코드 복잡성이 높아질 수 있다.
 */
public class AbstractFactoryTest {

    private static Button okButton;
    private static Button closeButton;
    private static Checkbox checkbox;
    private static TextEdit textEdit;

    @Test
    void macOSFactoryTest() {
        GUIFactory factory = new MacOSFactory();
        renderAndUse(factory);
        assertInstanceOf(MacOSButton.class, okButton);
        assertInstanceOf(MacOSButton.class, closeButton);
        assertInstanceOf(MacOSCheckbox.class, checkbox);
        assertInstanceOf(MacOSTextEdit.class, textEdit);
    }

    @Test
    void windowsFactoryTest() {
        GUIFactory factory = new WindowsFactory();
        renderAndUse(factory);
        assertInstanceOf(WindowsButton.class, okButton);
        assertInstanceOf(WindowsButton.class, closeButton);
        assertInstanceOf(WindowsCheckbox.class, checkbox);
        assertInstanceOf(WindowsTextEdit.class, textEdit);
    }

    private static void renderAndUse(GUIFactory factory) {
        okButton = factory.createButton("ok");
        closeButton = factory.createButton("close");
        checkbox = factory.createCheckbox(false);
        textEdit = factory.createTextEdit("enter your name.");

        okButton.render();
        closeButton.render();
        checkbox.render();
        textEdit.render();

        textEdit.setValue("Iron man");
        checkbox.setChecked(true);
        okButton.clickEvent();
        closeButton.clickEvent();
    }
}
