package builder.member;

public class MemberBuilder {

    private Long id;
    private String username;
    private String password;
    private String name;
    private int age;
    private String contact;
    private String email;

    public MemberBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public MemberBuilder setUsername(String username) {
        this.username = username;
        return this;
    }

    public MemberBuilder setPassword(String password) {
        this.password = password;
        return this;
    }

    public MemberBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public MemberBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public MemberBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public MemberBuilder setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public Member build() {
        return new Member(id, username, password, name, age, contact, email);
    }
}
