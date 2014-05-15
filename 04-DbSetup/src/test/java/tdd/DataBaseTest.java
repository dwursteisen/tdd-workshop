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

/**
 * User: david.wursteisen
 * Date: 15/05/14
 * Time: 13:47
 */
public class DataBaseTest {

    private static Connection ctx;

    @BeforeClass
    public static void setUpclass() throws Exception {
        JDBCDataSource datasource = new JDBCDataSource();
        datasource.setUrl("jdbc:hsqldb:mem:mymemdb");
        datasource.setUser("SA");
        datasource.setPassword("");

        ctx = datasource.getConnection();

        Operation operation = Operations.sql("CREATE TABLE users (id VARCHAR(255), name VARCHAR(255))");
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(datasource), operation);
        dbSetup.launch();
    }

    @Before
    public void setUp() {
        // fill the database
    }

    @Test
    public void should_test() throws SQLException {
        new UserRepository(ctx).findUserById("BLA");
    }
}
