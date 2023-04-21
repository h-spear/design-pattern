package singleton;

/**
 * DCL, Double Checked Locking
 *  - 인스턴스 생성 여부를 2번 체크한다.
 *  - getInstance() 메서드마다 lock을 거는 문제를 해결할 수 있다.
 */
public class Singleton_DCL {

    private volatile static Singleton_DCL instance = null;

    private Singleton_DCL() {
    }

    public static Singleton_DCL getInstance() {
        if (instance == null) {
            synchronized (Singleton_DCL.class) {
                if (instance == null) {
                    instance = new Singleton_DCL();
                }
            }
        }
        return instance;
    }
}
