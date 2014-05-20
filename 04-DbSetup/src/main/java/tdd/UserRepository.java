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

        // TODO: mettre la bonne requête SQL
        PreparedStatement statement = ctx.prepareStatement("??????????");
        statement.setString(1, id);

        ResultSet resultSet = statement.executeQuery();
        if(!resultSet.next()) {
            return null;
        }


        User user = new User();

        user.setId(resultSet.getString("id"));
        user.setName(resultSet.getString("userName"));

        return user;

    }
}
