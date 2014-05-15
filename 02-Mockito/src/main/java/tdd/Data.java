package tdd;

public class Data {

    private final String password;
    private final String id;

    public Data(String password, String id) {
        this.password = password;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isPasswordEquals(String password) {
        return this.password.equalsIgnoreCase(password);
    }
}
