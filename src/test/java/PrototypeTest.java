import org.junit.jupiter.api.Test;
import prototype.Circle;
import prototype.Rectangle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

/**
 * 일반적인 객체 생성 방법은 클래스를 정의하고, 이를 기반으로 객체를 생성하는 것
 * 하지만, 프로토타입 패턴은 이미 존재하는 객체를 복제하여 새로운 객체를 생성한다.
 *
 * 자바 : Cloneable 인터페이스
 * 사용1) 객체 생성 비용이 높은 경우
 * 사용2) 복잡한 객체를 생성해야 하는 경우
 *
 * 성능 향상 : 객체 생성 비용이 큰 경우 이미 생성된 객체를 생성하므로 비용이 줄 수 있다.
 * 객체 생성에 필요한 복잡한 과정을 생략할 수 있다.
 * 프로퍼티와 메서드가 너무 많은 객체의 경우 복제하기 어려울 수 있다.
 * 순환 참조가 있는 복잡한 객체를 복제하는 것이 어려울 수 있다.
 */
public class PrototypeTest {

    @Test
    void circlePrototypeTest() {
        Circle circle = new Circle();
        circle.x = 10;
        circle.y = 20;
        circle.radius = 15;
        circle.color = "red";

        Circle clone = (Circle) circle.clone();

        System.out.println("circle = " + circle);
        System.out.println("clone = " + clone);

        assertEquals(clone.x, 10);
        assertEquals(clone.y, 20);
        assertEquals(clone.radius, 15);
        assertEquals(clone.color, "red");
        assertEquals(circle, clone);
        assertNotSame(circle, clone);
    }

    @Test
    void rectanglePrototypeTest() {
        Rectangle rectangle = new Rectangle();
        rectangle.x = 10;
        rectangle.y = 20;
        rectangle.height = 30;
        rectangle.width = 20;
        rectangle.color = "blue";

        Rectangle clone = (Rectangle) rectangle.clone();

        System.out.println("rectangle = " + rectangle);
        System.out.println("clone = " + clone);

        assertEquals(clone.x, 10);
        assertEquals(clone.y, 20);
        assertEquals(clone.height, 30);
        assertEquals(clone.width, 20);
        assertEquals(clone.color, "blue");
        assertEquals(rectangle, clone);
        assertNotSame(rectangle, clone);
    }
}
