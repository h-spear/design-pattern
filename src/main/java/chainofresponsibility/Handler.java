package chainofresponsibility;

public abstract class Handler {
    protected Handler nextHandler = null;
    private int callCount = 0;  // 테스트용

    public Handler setNext(Handler handler) {
        this.nextHandler = handler;
        return handler;
    }

    public int getCallCount() {
        return callCount;
    }

    // Handler와 자식에서만 접근할 수 있도록 함
    // 자식클래스에서 내용 정의
    protected abstract void process(String username, String password);

    public void run(String username, String password) {
        callCount++;
        process(username, password);
        if (nextHandler != null) {
            nextHandler.run(username, password);
        }
    }
}
