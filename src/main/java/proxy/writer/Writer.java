package proxy.writer;

public abstract class Writer {
    protected int callCount = 0;

    public abstract void print(String content);

    public int getCallCount() {
        return callCount;
    }
}
