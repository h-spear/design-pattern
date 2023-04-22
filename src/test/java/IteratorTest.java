import iterator.array.Array;
import iterator.Element;
import iterator.Iterator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IteratorTest {

    /**
     * 컬렉션 구현 방법을 노출시키지 않으면서 집합체 안에 들어있는 모든 항목에 접근할 수 있는 방법을 제공한다.
     * 모든 항목에 일일히 접근하는 작업을 **컬렉션** 객체가 아닌 **반복자** 객체가 맡게 된다.
     * 집합체는 인터페이스 구현이 간단해지고, 반복 작업이 아닌 자신의 컬렉션 관리에만 전념할 수 있다.
     * 단순한 순회를 구현하는 경우는 클래스만 많아져 복잡해질 수 있다.
     */
    @Test
    void arrayIteratorTest() {
        Element[] elements = {
                new Element(1, "Issac"),
                new Element(2, "Avril"),
                new Element(3, "Jennifer"),
                new Element(4, "Aki"),
        };

        Array array = new Array(elements);
        Iterator iterator = array.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new Element(1, "Issac"));
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new Element(2, "Avril"));
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new Element(3, "Jennifer"));
        assertTrue(iterator.hasNext());
        assertEquals(iterator.next(), new Element(4, "Aki"));
        assertFalse(iterator.hasNext());
    }

    // https://leetcode.com/problems/binary-search-tree-iterator/
}
