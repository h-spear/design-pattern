import factory.Animal;
import factory.AnimalFactory;
import factory.AnimalType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactoryTest {

    @Test
    public void factoryTest() {
        Animal dog = AnimalFactory.createAnimal(AnimalType.DOG);
        Animal cat = AnimalFactory.createAnimal(AnimalType.CAT);

        assertEquals(dog.speak(), "bow wow");
        assertEquals(cat.speak(), "meow");
    }
}
