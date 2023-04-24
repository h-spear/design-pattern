import chainofresponsibility.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 기능을 responsibilty(클래스) 단위로 처리
 * 여러 개의 책임들을 동적으로 연결해서 동적으로 실행하는 패턴
 * 기능을 클래스별로 분리하여 구현하도록 유도하므로 클래스 코드가 최적화될 수 있다.
 * 요청의 처리 순서를 제어할 수 있다.
 * SRP : 요청을 처리하는 객체 간 의존성을 낮출 수 있다.
 * OCP : 새로운 Handler를 추가하거나 기존 객체를 삭제하기 쉽다.
 * 체인이 너무 길어지면 성능 저하가 발생할 수 있다.
 * 일부 요청이 처리되지 않을 수 있다.
 */
public class ChainOfResponsibilityTest {

    private static Map<String, String> users;

    @BeforeEach
    void beforeEach() {
        users = new HashMap<>();
        users.put("admin", "12345678");
        users.put("giraffe", "12345678");
        users.put("rabbit", "12345678");
    }

    @Test
    void loginTest() {
        LogHandler logHandler = new LogHandler();
        UserCheckHandler userCheckHandler = new UserCheckHandler(users);
        UserRoleCheckHandler userRoleCheckHandler = new UserRoleCheckHandler();

        logHandler.setNext(userCheckHandler).setNext(userRoleCheckHandler);

        logHandler.run("admin", "12345678");
        assertEquals(logHandler.getCallCount(), 1);
        assertEquals(userCheckHandler.getCallCount(), 1);
        assertEquals(userRoleCheckHandler.getCallCount(), 1);
    }

    @Test
    void loginFailTest_notExistsUsername() {
        LogHandler logHandler = new LogHandler();
        UserCheckHandler userCheckHandler = new UserCheckHandler(users);
        UserRoleCheckHandler userRoleCheckHandler = new UserRoleCheckHandler();

        logHandler.setNext(userCheckHandler).setNext(userRoleCheckHandler);

        assertThrows(IllegalArgumentException.class,
                () -> logHandler.run("anonymous", "12345678"),
                "username does not exist.");
        assertEquals(logHandler.getCallCount(), 1);
        assertEquals(userCheckHandler.getCallCount(), 1);
        assertEquals(userRoleCheckHandler.getCallCount(), 0);
    }

    @Test
    void loginFailTest_notMatchPassword() {
        LogHandler logHandler = new LogHandler();
        UserCheckHandler userCheckHandler = new UserCheckHandler(users);
        UserRoleCheckHandler userRoleCheckHandler = new UserRoleCheckHandler();

        logHandler.setNext(userCheckHandler).setNext(userRoleCheckHandler);

        assertThrows(IllegalArgumentException.class,
                () -> logHandler.run("admin", "87654321"),
                "password does not match.");
        assertEquals(logHandler.getCallCount(), 1);
        assertEquals(userCheckHandler.getCallCount(), 1);
        assertEquals(userRoleCheckHandler.getCallCount(), 0);
    }
}
