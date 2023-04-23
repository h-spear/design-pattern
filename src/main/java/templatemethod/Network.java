// https://refactoring.guru/ko/design-patterns/template-method/java/example#example-0--networks-Network-java

package templatemethod;

public abstract class Network {
    protected String username;
    protected String password;

    protected Network() {}

    public boolean post(String message) {
        if (login(this.username, this.password)) {
            boolean result = sendData(message.getBytes());
            logout();
            return result;
        }
        return false;
    }

    abstract boolean login(String username, String password);
    abstract boolean sendData(byte[] data);
    abstract void logout();
}
