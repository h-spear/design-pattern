import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import proxy.database.DatabaseAccessProxy;
import proxy.database.RealDatabaseAccess;
import proxy.writer.BufferedWriter;
import proxy.writer.ScreenWriter;
import proxy.writer.Writer;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * proxy : 대리인
 * 객체 간의 상호작용을 제어하기 위해 중간 계층(프록시)을 추가한다.
 * 중간 계층이 클라이언트가 실제 객체와 상호작용하는 것을 방지하고 대신 프록시 객체를 통해 상호작용하도록 유도한다.
 * 객체의 생성, 초기화를 늦추거나 필요한 경우에만 수행하도록 할 수 있다.(성능 개선)
 * 접근 제어 및 보안, 로깅, 캐싱 등 추가 기능을 프록시 객체에서 수행할 수 있따.
 * 원본 객체에 직접 접근하지 못하도록 할 수 있다.
 * 프록시 객체를 추가로 구현해야 하므로, 코드의 복잡성이 증가할 수 있다.
 * 프록시 객체가 실제 객체를 빈번하게 접근하는 경우 오히려 성능 저하의 원인이 될 수 있다.
 */
public class ProxyTest {

    private static final int RECORD_COUNT = 10;
    private HashMap<Long, String> database;

    /**
     * 예제 1 데이터베이스 테스트
     */
    @Test
    void realDatabaseAccessTest() {
        initDatabase();

        RealDatabaseAccess realDatabaseAccess = new RealDatabaseAccess(database);
        for (int i = 0; i < RECORD_COUNT; ++i) {
            realDatabaseAccess.getRecord((long) i);
        }
        assertEquals(realDatabaseAccess.getCallCount(), RECORD_COUNT);
    }

    @Test
    void databaseAccessProxyTest() {
        initDatabase();

        DatabaseAccessProxy databaseAccessProxy = new DatabaseAccessProxy(database);    // 프록시객체에서 추가작업 수행
        for (int i = 0; i < RECORD_COUNT; ++i) {
            databaseAccessProxy.getRecord((long) i);
        }
        assertEquals(databaseAccessProxy.getCallCount(), RECORD_COUNT);
    }

    private void initDatabase() {
        database = new HashMap<>();
        for (int i = 0; i < RECORD_COUNT; ++i) {
            database.put((long) i, "Record " + i);
        }
    }

    /**
     * 예제 2 Writer 테스트
     * https://www.youtube.com/watch?v=NoRPG06c48U&list=PLe6NQuuFBu7FhPfxkjDd2cWnTy2y_w_jZ&index=14
     */
    @Test
    public void screenWriterTest() {
        Writer writer = new ScreenWriter();
        long startTime = System.currentTimeMillis();
        writer.print("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        writer.print("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,");
        writer.print("when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
        writer.print("It has survived not only five centuries,");
        writer.print("but also the leap into electronic typesetting, remaining essentially unchanged.");
        writer.print("It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,");
        writer.print("and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("elapsedTime = " + elapsedTime + "ms");

        Assertions.assertEquals(writer.getCallCount(), 7);
    }

    @Test
    public void bufferedWriterTest() {
        Writer writer = new BufferedWriter(3);

        long startTime = System.currentTimeMillis();
        writer.print("Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        writer.print("Lorem Ipsum has been the industry's standard dummy text ever since the 1500s,");
        writer.print("when an unknown printer took a galley of type and scrambled it to make a type specimen book.");   // flush
        writer.print("It has survived not only five centuries,");
        writer.print("but also the leap into electronic typesetting, remaining essentially unchanged.");
        writer.print("It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages,");   // flush
        writer.print("and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        ((BufferedWriter) writer).flush();  // flush
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("elapsedTime = " + elapsedTime + "ms");

        Assertions.assertEquals(writer.getCallCount(), 3);
    }
}
