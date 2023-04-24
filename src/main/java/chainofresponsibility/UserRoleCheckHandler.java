package chainofresponsibility;

public class UserRoleCheckHandler extends Handler {

    @Override
    protected void process(String username, String password) {
        if (username.equals("admin")) {
            System.out.println("Hello admin!");
        } else {
            System.out.println("Hello user!");
        }
    }
}
