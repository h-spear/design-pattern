import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import visitor.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * https://www.youtube.com/watch?v=QC8Q5MWB-mQ&list=PLe6NQuuFBu7FhPfxkjDd2cWnTy2y_w_jZ&index=25
 *
 * Visitor : 방문자를 나타내는 인터페이스 (visit)
 * ConcreteVisitor : Visitor 구현체. 객체 구조를 방문하면서 수행할 작업을 구현
 * Element : 객체 구조의 원소를 나타내는 인터페이스 (accept)
 * ConcreteElement : Element 구현체. Visitor 객체를 받아들일 메서드를 구현
 *
 * 복잡한 객체 구조를 가진 클래스에 적합하다.
 * 객체 구조와 동작을 분리하여, 유연성과 확장성을 높일 수 있다.
 * 객체 간의 결합도가 낮아져, 유지보수가 용이해진다.
 *
 * 새로운 ConcreteElement, ConcreteVisitor를 추가할 때마다, 인터페이스를 수정해야한다.
 * 객체 구조가 복잡해지면 Visitor 클래스도 복잡해질 수 있다.
 */
public class VisitorTest {

    private static ItemList list1;
    private static ItemList list2;
    private static ItemList list3;

    @BeforeEach
    void beforeEach() {
        list1 = new ItemList();
        list1.add(new Item(10));
        list1.add(new Item(20));
        list1.add(new Item(40));

        list2 = new ItemList();
        list2.add(new Item(30));
        list2.add(new Item(40));

        list3 = new ItemList();
        list3.add(new Item(25));
        list3.add(new Item(70));
        list2.add(list3);   // 중첩
    }

    @Test
    void sumVisitorTest() {
        SumVisitor sumVisitor = new SumVisitor();

        list1.accept(sumVisitor);
        assertEquals(sumVisitor.getValue(), 70);

        list3.accept(sumVisitor);
        assertEquals(sumVisitor.getValue(), 165);

        sumVisitor.init();
        list2.accept(sumVisitor);
        assertEquals(sumVisitor.getValue(), 165);

        sumVisitor.init();
        list3.accept(sumVisitor);
        assertEquals(sumVisitor.getValue(), 95);
    }

    @Test
    void averageVisitorTest() {
        AverageVisitor avgVisitor = new AverageVisitor();

        list1.accept(avgVisitor);
        assertEquals(avgVisitor.getValue(), (double) 70/3);

        list3.accept(avgVisitor);
        assertEquals(avgVisitor.getValue(), (double) 165/5);

        avgVisitor.init();
        list2.accept(avgVisitor);
        assertEquals(avgVisitor.getValue(), (double) 165/4);

        avgVisitor.init();
        list3.accept(avgVisitor);
        assertEquals(avgVisitor.getValue(), (double) 95/2);
    }

    @Test
    void medianVisitorTest() {
        MedianVisitor medVisitor = new MedianVisitor();

        list1.accept(medVisitor);
        assertEquals(medVisitor.getValue(), 20);

        list3.accept(medVisitor);
        assertEquals(medVisitor.getValue(), 25);

        medVisitor.init();
        list2.accept(medVisitor);
        assertEquals(medVisitor.getValue(), 35.0);

        medVisitor.init();
        list3.accept(medVisitor);
        assertEquals(medVisitor.getValue(), 47.5);
    }
}
