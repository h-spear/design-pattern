package proxy.database;

import java.util.HashMap;

public class RealDatabaseAccess extends DatabaseAccess {


    public RealDatabaseAccess(HashMap<Long, String> database) {
        super(database);
    }

    @Override
    public String getRecord(Long id) {
        System.out.println("database access - id: " + id);
        this.callCount++;
        return database.get(id);
    }
}
