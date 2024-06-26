# Adapter(어댑터, ≒Wrapper)

-   어댑터는 호환되지 않는 인터페이스를 가진 객체들이 협업할 수 있도록 하는 구조적 디자인 패턴
-   기존 클래스를 감싼 새로운 클래스를 사용한다.
-   기능상 문제없이 동작하는 코드가 단지 인터페이스 차이 때문에 사용할 수 없는 경우 응용한다.
    -   또는 기존 코드에 오류가 있거나 보정 작업이 필요한 경우에도 유용하다.
    -   레거시 코드나 라이브러리를 재사용할 때 유용함
-   어댑터 클래스는 기존 클래스를 사용하고 싶지만 그 인터페이스가 나머지 코드와 호환되지 않을 때 사용한다.
-   사용하고자 하는 클래스를 기존 클라이언트가 사용하던 방식에 맞게 변경할 수 없는 경우 사용할 수 있다.
-   서로 호환되지 않는 인터페이스를 가진 코드를 사용할 수 있다.
-   복잡한 객체 구조를 깔끔하게 정리하는데 유용하다.
-   어댑터 패턴을 적용한다고 코드의 성능이 개선되지는 않는다.
    -   오히려 어댑터를 통하기 때문에 성능이 저하될 수 있다.
