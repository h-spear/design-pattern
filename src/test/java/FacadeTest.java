import facade.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * 여러 개의 복잡한 클래스나 서브 시스템을 감싸고, 이를 하나의 단순한 인터페이스로 제공하는 패턴
 * 사용자는 시스템 내부 구조나 동작 방식을 몰라도 간단한 인터페이스를 사용하여 시스템을 제어할 수 있다.
 * 복잡한 시스템을 단순화할 수 있다.
 * Facade 클래스를 통해 시스템의 객체와 메서드들을 단순한 하나의 인터페이스로 제공하므로 가독성이 향상된다.
 * 시스템 간의 결합도가 낮아진다.
 *  - 시스템의 구조나 구현이 변경되도 Facade 객체에서만 수정하면 된다.
 * Facade 객체가 모든 클래스가 결합된 God Object가 될 수도 있다는 문제
 */
public class FacadeTest {

    @Test
    void nonFacadeTest() {
        DBMS dbms = new DBMS();
        Cache cache = new Cache();

        Long id = 1L;

        Row row = cache.get(id);
        if (row == null) {
            row = dbms.query(id);
            if (row != null) {
                cache.put(row);
            }
        }

        User user = null;
        if (row != null) {
            user = User.of(row);
        }
        assertEquals(user.getName(), "user1");
        assertEquals(user.getEmail(), "test1@test.com");
    }

    @Test
    void facadeTest() {
        Facade facade = new Facade();

        User user = facade.getUser(1L);
        assertEquals(user.getName(), "user1");
        assertEquals(user.getEmail(), "test1@test.com");

        User invalidUser = facade.getUser(99L);
        assertNull(invalidUser);
    }
}
