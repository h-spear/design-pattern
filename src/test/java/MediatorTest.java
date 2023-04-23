import mediator.SmartHome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 객체 간의 복잡한 의존 관계들을 줄일 수 있는 행동 디자인 패턴
 * Mediator : 객체 간의 상호작용을 중재, 객체 간의 연결을 유지하며 객체 간의 메시지를 전달한다.
 * Colleague : 중재자를 통해 다른 객체와 상호작용
 * ***객체 간의 직접 통신을 제한하고 중재자 객체를 통해서만 협력하도록 한다.***
 * 다양한 컴포넌트간의 통신을 한 곳으로 추출하여 가독성을 높이고, 유지보수성을 높일 수 있다.
 * 객체 간의 직접적인 상호작용을 방지하여 객체 간의 종속성을 줄일 수 있다.
 * 객체 간의 상호작용은 자주 변경될 수 있는데 이를 중재자 객체의 메서드에서만 관리할 수 있다.
 * 중재자 객체의 복잡성이 증가할 수 있다.
 *  - 중재자가 God Object(여러 개의 책임을 직접 수행하는 객체)가 될 수 있다.
 */
public class MediatorTest {

    @Test
    void mediatorTest() {
        SmartHome smartHome = new SmartHome();

        assertTrue(smartHome.door.isClosed());
        assertTrue(smartHome.window.isClosed());
        assertFalse(smartHome.aircon.isRunning());
        assertFalse(smartHome.boiler.isRunning());

        smartHome.aircon.on();
        assertTrue(smartHome.door.isClosed());
        assertTrue(smartHome.window.isClosed());
        assertTrue(smartHome.aircon.isRunning());
        assertFalse(smartHome.boiler.isRunning());
        System.out.println();

        smartHome.window.open();
        assertTrue(smartHome.door.isClosed());
        assertFalse(smartHome.window.isClosed());
        assertFalse(smartHome.aircon.isRunning());
        assertFalse(smartHome.boiler.isRunning());
        System.out.println();

        smartHome.door.open();
        assertFalse(smartHome.door.isClosed());
        assertFalse(smartHome.window.isClosed());
        assertFalse(smartHome.aircon.isRunning());
        assertFalse(smartHome.boiler.isRunning());
        System.out.println();

        smartHome.boiler.on();
        assertTrue(smartHome.door.isClosed());
        assertTrue(smartHome.window.isClosed());
        assertFalse(smartHome.aircon.isRunning());
        assertTrue(smartHome.boiler.isRunning());
        System.out.println();
    }
}
