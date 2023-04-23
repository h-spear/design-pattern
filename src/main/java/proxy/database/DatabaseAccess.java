package proxy.database;

import java.util.HashMap;

public abstract class DatabaseAccess {
    // 테스트용
    protected int callCount = 0;

    protected final HashMap<Long, String> database;

    public DatabaseAccess(HashMap<Long, String> database) {
        this.database = database;
    }

    public abstract String getRecord(Long id);

    public int getCallCount() {
        return callCount;
    }
}
