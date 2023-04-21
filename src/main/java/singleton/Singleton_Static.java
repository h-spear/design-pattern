package singleton;

/**
 * Static Member, Static Block 사용
 *  - 정적 멤버나 정적 블록은 런타임이 아니라 최초에 JVM이 클래스 로딩 때 미리 인스턴스를 생성하는 것을 이용
 *  - 클래스 로딩과 동시에 싱글톤 인스턴스를 만든다.
 *  - 모듈들이 싱글톤 인스턴스를 요청할 때 그냥 처음에 만들어진 인스턴스를 반환한다.
 *  - 싱글톤 인스턴스가 필요없는 경우에도 무조건 인스턴스를 만들기 때문에 불필요한 자원낭비 발생
 */
public class Singleton_Static {

    // 인스턴스를 final로 선언
    private static final Singleton_Static INSTANCE = new Singleton_Static();

    private Singleton_Static() {
    }

    public static Singleton_Static getInstance() {
        return INSTANCE;
    }
}
