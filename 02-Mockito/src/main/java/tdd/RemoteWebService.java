package tdd;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: david
 * Date: 30/04/14
 * Time: 01:44
 * To change this template use File | Settings | File Templates.
 */
public interface RemoteWebService {

    User findUserById(String id);

    Data getData(User user);

    void saveUser(User user);

    User updateData(User user, Data data) throws IOException;
}
