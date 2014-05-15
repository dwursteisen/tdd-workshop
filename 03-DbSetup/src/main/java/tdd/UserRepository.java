package tdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: david.wursteisen
 * Date: 15/05/14
 * Time: 14:23
 */
public class UserRepository {


    private final Connection ctx;

    public UserRepository(final Connection ctx) {
        this.ctx = ctx;
    }

    public User findUserById(String id) throws SQLException {

        PreparedStatement statement = ctx.prepareStatement("SELECT id, name FROM users");
        ResultSet resultSet = statement.executeQuery();

        return null;

    }
}
