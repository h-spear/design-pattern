# Chain of Responsibility(책임 연쇄)

-   responsibility(책임) : 무언가를 처리하는 기능(클래스)
    -   Handler
        -   요청을 처리하는 인터페이스 또는 추상 클래스
        -   Handler를 필드로 가지며 다음 Handler를 연결한다.
    -   ConcreteHandler
        -   실제로 요청을 처리하는 객체
        -   처리 가능 여부를 확인하면 처리가 가능하면 요청을 처리한다.
-   여러 개의 책임들을 동적으로 연결해서 동적으로 실행하는 패턴
-   핸들러의 체인을 따라서 요청을 전달할 수 있게 해주는 디자인 패턴
-   **각 핸들러는 요청을 받으면 요청을 처리할지 아니면 체인의 다음 핸들러로 전달할지를 결정한다.**
-   기능을 클래스별로 분리하여 구현하도록 유도하므로 클래스의 코드가 최적화될 수 있다.
-   요청의 처리 순서를 제어할 수 있다.
-   단일 책임 원칙
    -   요청을 처리하는 객체 간의 의존성을 낮출 수 있다.
    -   ConcreteHandler 객체가 서로 독립적으로 존재하기 때문
-   개방/폐쇄 원칙
    -   새로운 ConcreteHandler를 추가하거나 기존 객체를 삭제하는 것이 쉽다.
-   체인이 너무 길어지면 성능 저하가 발생할 수 있다.
-   일부 요청이 처리되지 않을 수 있다.
