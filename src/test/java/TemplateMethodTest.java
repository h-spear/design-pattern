import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import templatemethod.Facebook;
import templatemethod.Network;
import templatemethod.Twitter;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 주요 클래스에서 알고리즘의 골격을 정의하여, 해당 알고리즘 골격 변경없이 특정 단계만 재정의할 수 있도록 만든 디자인 패턴
 * 어떤 작업을 처리하는 일부분을 서브 클래스로 캡슐화해 전체 일을 수행하는 구조는 바꾸지 않고 특정 단계만 변경할 수 있다.
 * 중복 코드를 줄일 수 있다.
 * 자식 클래스의 역할이 줄어 핵심 로직 관리가 용이하다.
 * 추상 메서드가 많아져 클래스 관리가 복잡해질 수 있다.
 */
public class TemplateMethodTest {

    private final String USERNAME = "Giraffe";
    private final String PASSWORD = "12345678";
    private final String CONTENT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.";

    @Test
    void templateMethodFacebookTest() {
        Network network = new Facebook(USERNAME, PASSWORD);
        boolean result = network.post(CONTENT);
        assertTrue(result);
    }

    @Test
    void templateMethodTwitterTest() {
        Network network = new Twitter(USERNAME, PASSWORD);
        boolean result = network.post(CONTENT);
        assertTrue(result);
    }
}
