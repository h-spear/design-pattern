package singleton;

/**
 * 단순한 메서드 호출
 *  - 메서드의 원자성이 결여되어 있다.
 *  - 멀티스레드 환경에서 싱글톤 인스턴스가 2개 생성될 수 있다.
 */
public class Singleton_Basic {

    private static Singleton_Basic instance = null;

    private Singleton_Basic() {
    }

    public static Singleton_Basic getInstance() {
        if (instance == null) {
            instance = new Singleton_Basic();
        }
        return instance;
    }
}
