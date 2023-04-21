package singleton;

public class Singleton_StaticBlock {

    private static Singleton_StaticBlock instance;

    static {
        instance = new Singleton_StaticBlock();
    }

    private Singleton_StaticBlock() {
    }

    public static Singleton_StaticBlock getInstance() {
        return instance;
    }
}
