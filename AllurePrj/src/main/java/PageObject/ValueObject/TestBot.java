package PageObject.ValueObject;

import java.util.Objects;

public class TestBot {
    private final String username;
    private final String password;

    public TestBot(String username, String password){
        this.password = password;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TestBot testBot = (TestBot) o;
        return Objects.equals(username, testBot.username) && Objects.equals(password, testBot.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
