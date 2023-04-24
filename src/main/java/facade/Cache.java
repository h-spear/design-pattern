package facade;

import java.util.HashMap;
import java.util.Map;

public class Cache {

    private Map<Long, Row> cache = new HashMap<>();

    public void put(Row row) {
        cache.put(row.getId(), row);
    }

    public Row get(Long id) {
        return cache.get(id);
    }
}
