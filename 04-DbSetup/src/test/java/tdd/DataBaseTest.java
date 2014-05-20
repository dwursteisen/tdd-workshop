package tdd;

import java.sql.Connection;
import java.sql.SQLException;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.hsqldb.jdbc.JDBCDataSource;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static org.assertj.core.api.Assertions.*;

/**
 * User: david.wursteisen
 * Date: 15/05/14
 * Time: 13:47
 */
public class DataBaseTest {

    private static Connection ctx;
    private static JDBCDataSource datasource;

    @BeforeClass
    public static void setUpclass() throws Exception {
        datasource = new JDBCDataSource();
        datasource.setUrl("jdbc:hsqldb:mem:mymemdb");
        datasource.setUser("SA");
        datasource.setPassword("");

        ctx = datasource.getConnection();

        // création de la table qui va bien
        Operation operation = Operations.sql("CREATE TABLE users (id VARCHAR(255), userName VARCHAR(255))");
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(datasource), operation);
        dbSetup.launch();
    }

    @Before
    public void setUp() {
        // insertion de données dans la base
        Operation operation = null;
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(datasource), operation);
        dbSetup.launch();
    }

    @Test
    public void should_not_find_user() throws SQLException {
        User user = new UserRepository(ctx).findUserById("BLA");
        assertThat(user).isNull();
    }

    @Test
    public void should_find_user() throws SQLException {
        User user = new UserRepository(ctx).findUserById("AZERTY");
        assertThat(user).isNotNull();
    }
}
