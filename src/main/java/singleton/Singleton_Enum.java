package singleton;

/**
 * enum의 인스턴스는 기본적으로 thread-safe가 보장된다.
 *
 * A single-element enum type is the best way to implement a singleton
 *   - Joshua Bloch, Effective Java 2nd Edition p.18
 */
public enum Singleton_Enum {
    INSTANCE;

    public void logic() {

    }
}
