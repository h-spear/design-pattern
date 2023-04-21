package singleton;

/**
 * Lazy Holder(중첩 클래스) 사용
 *  - SingletonInstanceHolder라는 내부 클래스를 하나 만든다.
 *  - 최초에 로딩되더라도 함께 초기화되지 않는다.
 *  - getInstance() 메서드가 호출될 때 SingletonInstanceHolder 클래스가 로딩되어 인스턴스를 생성한다.
 *  - 가장 많이 쓰인다고 알려져있다.
 */
public class Singleton_Holder {

    private static class SingletonInstanceHolder {
        private static final Singleton_Holder INSTANCE = new Singleton_Holder();
    }

    public static Singleton_Holder getInstance() {
        return SingletonInstanceHolder.INSTANCE;
    }
}
