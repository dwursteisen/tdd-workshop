package tdd;

import java.io.IOException;

public class AuthChecker {

    private final RemoteWebService service;


    public AuthChecker(RemoteWebService service) {
        this.service = service;
    }


    public boolean isUserExist(String userId) {
        return service.findUserById(userId) != null;
    }

    public boolean isAutorized(User user, String password) {
        Data data = service.getData(user);
        return data.isPasswordEquals(password);
    }


    public void createNewUser(String userId) {
        User user = new User(userId);
        service.saveUser(user);
    }

    public User updateUser(User user, String description) {
        Data data = service.getData(user);
        try {
            return service.updateData(user, data);
        } catch (IOException e) {
            return null;
        }
    }
}
