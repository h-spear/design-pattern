package factorymethod;

public class DogFactory implements AnimalFactory {

    // 팩토리 메서드를 오버라이드
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
