import factorymethod.Animal;
import factorymethod.CatFactory;
import factorymethod.DogFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryMethodTest {

    /**
     * 객체간의 결합도를 낮출 수 있다.
     * SRP
     * OCP : 기존 클라이언트 코드 변경없이 새로운 타입을 추가할 수 있다.
     * 패턴을 구현할 서브 클래스가 추가되기 때문에 코드가 복잡해질 수 있다.
     */

    @Test
    public void factoryMethodTest() {
        CatFactory catFactory = new CatFactory();
        Animal cat1 = catFactory.createAnimal();
        Animal cat2 = catFactory.createAnimal();

        DogFactory dogFactory = new DogFactory();
        Animal dog = dogFactory.createAnimal();

        assertEquals(cat1.speak(), "meow");
        assertEquals(cat2.speak(), "meow");
        assertEquals(catFactory.getCreateCount(), 2);

        assertEquals(dog.speak(), "bow wow");
    }
}
