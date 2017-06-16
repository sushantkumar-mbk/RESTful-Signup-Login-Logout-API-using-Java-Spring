package hello;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String Id;
    private final String username;
    private final String password;
    private final long balance;

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    private boolean isLoggedIn;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 100;
        this.isLoggedIn = false;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public long getBalance(){
        return balance;
    }
}
