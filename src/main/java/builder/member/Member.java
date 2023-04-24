package builder.member;

public class Member {

    private Long id;
    private String username;
    private String password;
    private String name;
    private int age;
    private String contact;
    private String email;

    public Member(Long id, String username, String password, String name, int age, String contact, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContact() {
        return contact;
    }

    public String getEmail() {
        return email;
    }
}
