# Observer(옵저버)

-   옵저버(객체의 상태 변화를 관찰하는 관찰자)들의 목록을 객체에 등록하여 상태 변화가 있을 때마다 메서드를 통해 객체가 각 옵저버에게 통지하도록 하는 디자인 패턴
-   분산 이벤트 핸들링 시스템 구현(발행/구독 모델과 유사)
-   어떤 객체의 상태가 변할 때 그와 연관된 객체들에게 알림을 보내는 디자인 패턴
-   주체 객체(Publisher, Subject)와 상태 변경을 알아야 하는 관찰 객체(Observer)가 존재하며 이들의 관계는 1:1 또는 1:N
-   실시간으로 한 객체의 변경사항을 다른 객체에 전파할 수 있다.
-   주체 객체와 관찰 객체 간에 느슨한 결합을 구현할 수 있다.
    -   주체 객체의 변경이 옵저버 객체에 영향을 미치지 않도록 구현할 수 있다.
-   주체 객체와 관찰 객체 간의 관심사를 분리할 수 있다.
    -   주체 객체는 상태 변화에만, 관찰 객체는 처리하는 로직에만 집중할 수 있다.
-   너무 많이 사용하면 상태 관리, 디버깅이 어려울 수 있다.
-   여러 개의 옵저버 객체가 등록되어 있을 때, 이들 간에 메시지 전달 순서를 보장하기 어려울 수 있다.