# Flyweight(플라이웨이트)

-   어떤 객체를 사용하기 위해 매번 생성하지 않고 한번만 생성하고 다시 필요해질 때에는 이전에 생성된 객체를 재사용
-   객체를 생성할 때 많은 자원을 소모할 경우 플라이웨이트 패턴을 적용하여 훨씬 적은 자원만으로 필요한 객체를 재사용할 수 있다.
-   각 객체에 모든 데이터를 유지하는 대신 여러 객체들 간에 상태의 공통 부분들을 공유하여 사용할 수 있는 RAM에 더 많은 객체를 포함할 수 있도록 한 구조
-   인스턴스 한 개만으로 여러 개의 “가상 인스턴스”를 제공하고 싶을 때 사용하는 패턴
-   플라이웨이트는 생성자 매개변수를 통해 상태를 한번만 초기화해야 한다.
    -   setter, public 필드를 다른 객체에 노출해서는 안된다.
-   **인스턴스를 가능한대로 공유시켜 쓸데없이 new 연산자를 통한 메모리 낭비를 줄이는 방식**
-   Flyweight Factory
    -   다양한 플라이웨이트들에 편리하게 액세스하기 위해 기존 플라이웨이트 객체들의 풀을 관리하는 팩토리 메서드
    -   클라이언트에서 원하는 상태를 매개변수로 일치하는 객체를 찾아 반환
    -   없으면 새 플라이웨이트를 생성해서 풀에 추가한다.
    -   Singleton 패턴으로 구현할 수 있다.
-   유사한 객체들이 많다면 메모리 공간을 절약할 수 있다.
-   여러 가상 객체의 상태를 한 곳에 집중시켜놓을 수 있다.
-   코드가 복잡해진다.
-   객체의 값을 변경하면 공유받은 “가상 인스턴스”를 사용하는 곳에도 영향을 줄 수 있다.
-   특정 인스턴스만 다른 인스턴스처럼 동작하도록 하는 것이 불가능하다.
