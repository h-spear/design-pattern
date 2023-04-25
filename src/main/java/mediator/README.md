# Mediator(중재자)

-   객체 간의 혼란스러운 의존 관계들을 줄일 수 있는 행동 디자인 패턴
    -   Mediator : 객체 간의 상호작용을 중재하는 클래스로, 객체 간의 연결을 유지하며 객체 간의 메시지를 전달한다.
    -   Colleague(≒Participant) : 중재자를 통해 다른 객체와 상호작용하는 객체
-   객체 간의 직접 통신을 제한하고 중재자 객체를 통해서만 협력하도록 한다.
-   다양한 컴포넌트 간의 통신을 한 곳으로 추출하여 가독성을 높이고, 유지보수성을 높일 수 있다.
-   객체 간의 직접적인 상호작용을 방지하여 객체 간의 종속성을 줄일 수 있다.
    -   프로그램의 다양한 컴포넌트 간의 결합도를 줄일 수 있다.
-   실제 컴포넌트를 변경하지 않고도 새로운 중재자를 추가할 수 있다.
-   중재자 객체의 복잡성이 증가할 수 있다.
    -   중재자가 God Object가 될 수 있다.
    -   God Object : 여러 개의 책임을 자신의 속성과 행동으로 직접 수행하는 객체
-   객체 간의 상호작용이 추가될 때마다 중재자 객체를 수정해야할 수 있다.