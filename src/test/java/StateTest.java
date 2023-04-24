import org.junit.jupiter.api.Test;
import state.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

/**
 * 상태를 객체화한 패턴
 * 객체의 내부 상태가 변경될 때 해당 객체가 그의 행동을 변경할 수 있도록 하는 패턴
 * 객체가 행동을 변경할 때 객체가 클래스를 변경한 것처럼 보일 수 있다.
 *
 * 거대한 프로그램(Finite-State Machine)의 조건문을 효과적으로 제거하여 코드를 단순화할 수 있다.
 * 단일 책임 원칙 : 특정 상태에 관련된 코드를 별도의 클래스로 구성할 수 있다.
 * 개방/폐쇄 원칙 : Context 코드 변경없이 기존 상태 클래스를 변경, 추가할 수 잇다.
 * 상태가 적을 때 상태 패턴을 적용하는 것은 낭비가 될 수 있다.
 * 객체 간의 상호작용이 복잡해지고 코드가 길어질 수 있다.
 */
public class StateTest {

    @Test
    void stateTest() {
        Player player = new Player("Player");
        assertInstanceOf(StandUpState.class, player.getState());
        assertEquals(player.getSpeed(), 0);

        player.getState().standUp();    // 서있다가 서기
        assertInstanceOf(StandUpState.class, player.getState());
        assertEquals(player.getSpeed(), 0);

        player.getState().sitDown();    // 서있다가 앉기
        assertInstanceOf(SitDownState.class, player.getState());
        assertEquals(player.getSpeed(), 0);

        player.getState().run();        // 앉아있다 뛰기 -> 일어서기
        assertInstanceOf(StandUpState.class, player.getState());
        assertEquals(player.getSpeed(), 0);

        player.getState().run();        // 서있다가 뛰기
        assertInstanceOf(RunState.class, player.getState());
        assertEquals(player.getSpeed(), 15);

        player.getState().run();        // 또 뛰기
        assertInstanceOf(RunState.class, player.getState());
        assertEquals(player.getSpeed(), 17);

        player.getState().run();        // 또 뛰기
        assertInstanceOf(RunState.class, player.getState());
        assertEquals(player.getSpeed(), 19);

        player.getState().run();        // 또 뛰기
        assertInstanceOf(RunState.class, player.getState());
        assertEquals(player.getSpeed(), 21);

        player.getState().walk();        // 뛰다가 걷기
        assertInstanceOf(WalkState.class, player.getState());
        assertEquals(player.getSpeed(), 8);

        player.getState().sitDown();     // 걷다가 앉기
        assertInstanceOf(SitDownState.class, player.getState());
        assertEquals(player.getSpeed(), 0);

        player.getState().walk();        // 앉아있다 걷기 -> 일어서기
        assertInstanceOf(StandUpState.class, player.getState());
        assertEquals(player.getSpeed(), 0);
    }
}
