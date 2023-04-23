package proxy.database;

import java.util.HashMap;

public class DatabaseAccessProxy extends DatabaseAccess {

    private RealDatabaseAccess realDatabaseAccess;

    public DatabaseAccessProxy(HashMap<Long, String> database) {
        super(database);
    }

    @Override
    public String getRecord(Long id) {
        if (realDatabaseAccess == null) {
            realDatabaseAccess = new RealDatabaseAccess(database);
        }
        callCount++;
        System.out.println("proxy object - extra work for record id: " + id);
        return realDatabaseAccess.getRecord(id);
    }
}
