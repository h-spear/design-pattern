package builder.data;

/**
 * Director
 *  - Facade, Template Method, Strategy
 *  - 객체 생성 과정을 제어하는 클래스, 생성된 객체를 반환
 */
public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public String build() {
        StringBuilder sb = new StringBuilder();
        sb.append(builder.head());
        sb.append(builder.body());
        sb.append(builder.foot());
        return sb.toString();
    }
}
