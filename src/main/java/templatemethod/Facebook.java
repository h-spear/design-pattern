package templatemethod;

public class Facebook extends Network {

    public Facebook(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String username, String password) {
        System.out.println("\nChecking user's parameters");
        System.out.println("Username: " + this.username);
        System.out.print("Password: " + "*".repeat(this.password.length()));
        if (this.username.equals(username) && this.password.equals(password)) {
            System.out.println("\n\nLogin: User '" + this.username + "' was logged in on Facebook");
            return true;
        }
        return false;
    }

    @Override
    boolean sendData(byte[] data) {
        boolean messagePosted = true;
        if (messagePosted) {
            System.out.println("Message: '" + new String(data) + "' was posted on Facebook");
            return true;
        } else {
            return false;
        }
    }

    @Override
    void logout() {
        System.out.println("Logout: User '" + username + "' was logged out from Facebook");
    }
}
