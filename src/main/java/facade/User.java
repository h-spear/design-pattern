package facade;

public class User {
    private String name;
    private String email;

    private User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public static User of(Row row) {
        return new User(row.getName(), row.getEmail());
    }
}
