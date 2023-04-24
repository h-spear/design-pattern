package facade;

import java.util.HashMap;
import java.util.Map;

public class DBMS {
    private Map<Long, Row> db = new HashMap<>();

    public DBMS() {
        db.put(1L, new Row("user1", "test1@test.com"));
        db.put(2L, new Row("user2", "test2@test.com"));
    }

    public Row query(Long id) {
        return db.get(id);
    }
}
