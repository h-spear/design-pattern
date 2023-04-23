import adapter.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 호환되지 않는 인터페이스를 가진 객체들이 협업할 수 있도록하는 디자인 패턴
 * 기존 호환되지 않는 클래스를 감싼 **새로운 클래스**를 사용한다.
 * 기능상에는 다른 클래스와 문제없이 동작할 수 있지만, 인터페이스만이 차이가 날 때 사용한다.
 * 기존 코드에 오류가 있거나 보정 작업이 필요한 경우(레거시 코드, 라이브러리)
 * 서로 호환되지 않는 인터페이스를 가진 코드를 사용할 수 있다.
 * 어댑터 패턴을 적용한다고 코드의 성능이 개선되지는 않는다)
 *   - 오히려 어댑터를 통하기 때문에 성능이 저하될 수 있다.
 */
public class AdapterTest {

    private final String PATH = "C:/documents";

    @Test
    void adapterTest() {
        List<FileStore> stores = new ArrayList<>();
        stores.add(new ImageFileStore(PATH, "이미지 파일1"));
        stores.add(new ImageFileStore(PATH, "이미지 파일2"));
        stores.add(new TextFileStore(PATH, "텍스트 파일"));
//        stores.add(new ExcelFileStore());  // 인터페이스가 일치하지 않음
        stores.add(new ExcelFileStoreAdapter(PATH, "엑셀 파일1"));    // 어댑터 패턴
        stores.add(new ExcelFileStoreAdapter(PATH, "엑셀 파일2"));

        for (FileStore store: stores) {
            boolean result = store.save();
            assertTrue(result);
        }
    }
}
