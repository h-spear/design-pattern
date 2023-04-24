package facade;

public class Facade {

    private DBMS dbms = new DBMS();
    private Cache cache = new Cache();

    public User getUser(Long id) {
        Row row = cache.get(id);
        if (row == null) {
            row = dbms.query(id);
            if (row != null) {
                cache.put(row);
            }
        }

        if (row == null) {
            return null;
        }
        return User.of(row);
    }
}
