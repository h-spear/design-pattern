package chainofresponsibility;

public class LogHandler extends Handler {

    @Override
    protected void process(String username, String password) {
        System.out.println("user " + username + " have attempted to login.");
    }
}
