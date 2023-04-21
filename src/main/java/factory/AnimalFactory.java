package factory;

public class AnimalFactory {

    public static Animal createAnimal(AnimalType type) {
        if (type == AnimalType.DOG) {
            return new Dog();
        } else if (type == AnimalType.CAT) {
            return new Cat();
        } else {
            return null;
        }
    }
}
