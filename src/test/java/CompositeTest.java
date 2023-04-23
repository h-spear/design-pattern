import composite.Directory;
import composite.File;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://www.youtube.com/watch?v=g96bJvVDZPs&list=PLe6NQuuFBu7FhPfxkjDd2cWnTy2y_w_jZ&index=9
 *
 * Leaf : 단일 객체, 내부에 다른 것을 넣을 수 없다
 * Composite : 복합체, Leaf나 Composite를 넣을 수 있다.
 * Component : Leaf, Composite의 역할을 동일시하며, 둘의 상위 클래스이다.
 *
 * 객체들이 모두 같은 타입으로 취급되어 새로운 클래스 추가가 용이하다.
 * 복잡한 트리 구조를 편리하게 사용할 수 있다.
 * 기능이 많은 다른 클래스들의 공통 인터페이스를 제공하도록 설계하는 것이 어려울 수 있다.
 * 설계가 지나치게 범용성을 가지게 되고, 복합체 구성 요소에 제약을 가하기 어려운 구조가 된다.
 */
public class CompositeTest {

    @Test
    void compositeTest() {
        Directory root = new Directory("root");
        root.add(new File("File1", 1000));

        Directory dir1 = new Directory("directory1");
        dir1.add(new File("File2", 1000));
        dir1.add(new File("File3", 1000));

        Directory dir2 = new Directory("directory2");
        dir2.add(new File("File4", 2000));
        dir2.add(new File("File5", 5000));

        Directory dir3 = new Directory("directory3");
        dir3.add(new File("File6", 2000));

        Directory dir4 = new Directory("directory4");
        dir4.add(new File("File7", 400));
        dir4.add(new File("File8", 3000));

        dir3.add(dir4);

        root.add(dir1);
        root.add(dir2);
        root.add(dir3);

        root.list();

        Assertions.assertEquals(root.getSize(), 15400);
        Assertions.assertEquals(dir1.getSize(), 2000);
        Assertions.assertEquals(dir2.getSize(), 7000);
        Assertions.assertEquals(dir3.getSize(), 5400);
        Assertions.assertEquals(dir4.getSize(), 3400);
    }
}
