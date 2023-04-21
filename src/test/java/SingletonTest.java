import org.junit.jupiter.api.Test;
import singleton.*;

import static org.junit.jupiter.api.Assertions.*;

class SingletonTest {

    @Test
    public void singletonBasicTest() {
        Singleton_Basic instance1 = Singleton_Basic.getInstance();
        Singleton_Basic instance2 = Singleton_Basic.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    public void singletonSynchronizedTest() {
        Singleton_Synchronized instance1 = Singleton_Synchronized.getInstance();
        Singleton_Synchronized instance2 = Singleton_Synchronized.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    public void singletonStaticTest() {
        Singleton_Static instance1 = Singleton_Static.getInstance();
        Singleton_Static instance2 = Singleton_Static.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    public void singletonStaticBlockTest() {
        Singleton_StaticBlock instance1 = Singleton_StaticBlock.getInstance();
        Singleton_StaticBlock instance2 = Singleton_StaticBlock.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    public void singletonHolderTest() {
        Singleton_Holder instance1 = Singleton_Holder.getInstance();
        Singleton_Holder instance2 = Singleton_Holder.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    public void singletonDCLTest() {
        Singleton_DCL instance1 = Singleton_DCL.getInstance();
        Singleton_DCL instance2 = Singleton_DCL.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    public void singletonEnumTest() {
        Singleton_Enum instance1 = Singleton_Enum.INSTANCE;
        Singleton_Enum instance2 = Singleton_Enum.INSTANCE;

        assertSame(instance1, instance2);
    }
}
