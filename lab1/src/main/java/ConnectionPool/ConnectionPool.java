package ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public abstract class ConnectionPool {

    static ResourceBundle resource = ResourceBundle.getBundle("properties/database");

    private static final String URL = resource.getString("url");
    private static final String USER = resource.getString("user");
    private static final String PASSWORD = resource.getString("password");
    private static final int INITIAL_POOL_SIZE = 10;

    static List<Connection> connectionPool = new ArrayList<Connection>();

    public ConnectionPool() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        connectionPool = new ArrayList<>();
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            connectionPool.add(createConnection());
        }
    }

    private static Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static synchronized Connection getConnection() throws SQLException {
        System.out.println(DriverManager.getDrivers());
        if (connectionPool.isEmpty()) {
            connectionPool.add(createConnection());
        }
        return connectionPool.remove(0);
    }

    public static synchronized void releaseConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connectionPool.add(connection);
        }
    }

    public static void closeAllConnections() throws SQLException {
        for (Connection connection : connectionPool) {
            connection.close();
        }
        connectionPool.clear();
    }
}
