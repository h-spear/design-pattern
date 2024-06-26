# Strategy(전략)

-   실행 중에 알고리즘을 선택할 수 있게 하는 행위 패턴
-   사용하는 전략과 클라이언트는 독립적으로 만든다.
-   **특정 컨텍스트에서 알고리즘을 별도로 분리하는 설계 방법**
    -   특정한 기능을 수행하는 데에 다양한 알고리즘이 적용될 수 있는 경우, 해당 알고리즘을 별도로 분리하는 설계 방법
    -   ex) Page Replacement Simulator
-   컨텍스트에 적용되는 알고리즘이 한 두개인 경우에는 분기를 타는 것이 편할 수 있다.
-   공통 로직이 부모 클래스에 있지 않고 Context(별도의 클래스)에 존재하기 때문에 구현체들에 대한 영향도가 적음
-   Context가 Strategy 인터페이스를 의존하고 있기 때문에 구현체를 갈아끼우기 쉬움
-   런타임에 전략을 변경할 수 있다.
-   새로운 Strategy를 추가하더라도 기존 코드를 변경하지 않는다.
-   로직이 늘어날 때마다 구현체 클래스가 늘어나 복잡도가 증가한다.
-   클라이언트가 구체적인 전략을 알아야 한다.
