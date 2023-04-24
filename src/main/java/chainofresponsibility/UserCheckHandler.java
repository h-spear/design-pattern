package chainofresponsibility;

import java.util.Map;

public class UserCheckHandler extends Handler {

    private final Map<String, String> data;

    public UserCheckHandler(Map<String, String> data) {
        this.data = data;
    }

    @Override
    protected void process(String username, String password) {
        if (!data.containsKey(username)) {
            throw new IllegalArgumentException("username does not exist.");
        }
        if (!data.get(username).equals(password)) {
            throw new IllegalArgumentException("password does not match.");
        }
    }
}
