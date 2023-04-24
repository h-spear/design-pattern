package builder.data;

/**
 * Builder
 */
public abstract class Builder {
    protected Data data;    // 자식 클래스에서 사용

    public Builder(Data data) {
        this.data = data;
    }

    public abstract String head();
    public abstract String body();
    public abstract String foot();
}
