package factorymethod;

public class CatFactory implements AnimalFactory {

    private int createCount = 0;    // 팩토리에 기능 추가

    // 팩토리 메서드를 오버라이드
    @Override
    public Animal createAnimal() {
        this.createCount++;
        return new Cat();
    }

    public int getCreateCount() {
        return createCount;
    }
}
