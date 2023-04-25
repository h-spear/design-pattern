# Visitor(비지터)

-   객체의 구조와 동작을 분리하는 패턴
    -   데이터 구조와 데이터 동작을 분리
    -   알고리즘과 작동하는 객체들을 분리
-   데이터 구조는 Composite Pattern을 사용해 표현한다.
-   각 클래스가 자신만의 특성을 유지하면서, 새로운 기능을 추가하거나 변경하는 것이 가능하다.
-   구성
    -   Visitor : 방문자를 나타내는 인터페이스 (visit)
    -   ConcreteVisitor : Visitor 구현체. 객체 구조를 방문하면서 수행할 작업을 구현
    -   Element : 객체 구조의 원소를 나타내는 인터페이스 (accept)
    -   ConcreteElement : Element 구현체. Visitor 객체를 받아들일 메서드를 구현
    -   ObjectStructure : ConcreteElement 객체들을 관리하는 클래스. Visitor가 ConcreteElement 객체들을 방문할 수 있도록 함
-   복잡한 객체 구조를 가진 클래스에 적합하다.
-   객체 구조와 동작을 분리하여, 유연성과 확장성을 높일 수 있다.
-   객체 간의 결합도가 낮아져, 유지보수가 용이해진다.
-   새로운 ConcreteElement, ConcreteVisitor를 추가할 때마다, 인터페이스를 수정해야한다.
-   객체 구조가 복잡해지면 Visitor 클래스도 복잡해질 수 있다.
