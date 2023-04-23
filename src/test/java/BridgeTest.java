import bridge.device.Device;
import bridge.device.Radio;
import bridge.device.Tv;
import bridge.remote.AdvancedRemote;
import bridge.remote.BasicRemote;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 큰 클래스 또는 관련된 클래스들의 집합을 두 개의 계층 구조로 나누어 각각 독립적으로 개발할 수 있도록 한 패턴
 * 상속 -> 객체 합성
 * 어떤 기능의 여러 변형을 가진 모놀리식 클래스를 나누고 정돈할 때 유용
 * 구현과 추상화 된 부분을 분리하여 독립적으로 확장할 수 있다.
 * 코드 유지 보수에 편리하고, 기존 코드 손상 위험을 최소화할 수 있다.
 * 디자인이 복잡해질 수 있다.
 */
public class BridgeTest {

    private static final int DEFAULT_VOLUME = 30;
    private static final int DEFAULT_CHANNEL = 1;

    @Test
    void bridgeTest() {
        System.out.println("Device TV...\n");
        testDevice(new Tv(DEFAULT_VOLUME, DEFAULT_CHANNEL));

        System.out.println("\n\nDevice Radio...\n");
        testDevice(new Radio(DEFAULT_VOLUME, DEFAULT_CHANNEL));
    }

    void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        basicRemote.channelUp();
        basicRemote.volumeDown();
        device.printStatus();
        assertTrue(device.isEnabled());
        assertEquals(device.getChannel(), DEFAULT_CHANNEL + 1);
        assertEquals(device.getVolume(), DEFAULT_VOLUME - 10);

        System.out.println("\nTests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.mute();
        advancedRemote.power();
        assertFalse(device.isEnabled());
        assertEquals(device.getVolume(), 0);
        device.printStatus();
    }
}
