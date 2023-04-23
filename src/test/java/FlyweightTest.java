import flyweight.Digit;
import flyweight.Number;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 어떤 객체를 사용하기 위해 매번 생성하지 않고 한번만 생성하고, 다시 필요할 때에는 이전에 생성된 객체를 재활용
 * 각 객체에 모든 데이터를 유지하는 대신 여러 객체들 간에 상태의 공통 부분을 공유하여 사용한다.
 * **유사한 객체들이 많다면 메모리 공간을 절약할 수 있다.**
 * 코드가 복잡해질 수 있다.
 * 객체의 값을 변경하면 공유받은 가상 인스턴스를 사용하는 곳에도 영향을 줄 수 있다.
 * Flyweight Factory
 *  - 다양한 플레이웨이트에 편리하게 액세스하기 위해 기존 플라이웨이트 객체 풀을 관리하는 팩토리 메서드
 *  - 클라이언트에서 원하는 객체를 찾아 반환, 없으면 객체를 생성 후 풀에 저장
 */
public class FlyweightTest {

    // 3 4 5 6 7 8 9
    private final String NUMBER = "84984354357864764993456765765757697";

    @AfterEach
    void afterEach() {
        Digit.resetCallCount();
    }

    @Test
    void flyweightTest() {
        System.out.println("==== Flyweight ====");
        Number number = new Number(NUMBER);
        number.print();

        assertEquals(Digit.getCallCount(), 7);  // 사용된 숫자만 생성(중복 객체 생성 X)
    }

    @Test
    void nonFlyweightTest() {
        System.out.println("==== Flyweight(X) ====");
        for (char c: NUMBER.toCharArray()) {
            int n = Character.getNumericValue(c);
            String fileName = String.format("src/main/resources/digits/%d.txt", n);
            Digit digit = new Digit(fileName);
            digit.print();
            System.out.println();
        }
        assertEquals(Digit.getCallCount(), NUMBER.length());
    }
}
