package singleton;

/**
 * synchronized 키워드 사용
 *  - getInstance() 메서드를 동시에 여러 스레드가 접근하지 못함
 *  - getInstance() 메서드 호출마다 lock이 걸려 성능이 저하된다.
 */
public class Singleton_Synchronized {

    private static Singleton_Synchronized instance = null;

    private Singleton_Synchronized() {
    }

    public static synchronized Singleton_Synchronized getInstance() {
        if (instance == null) {
            instance = new Singleton_Synchronized();
        }
        return instance;
    }
}
