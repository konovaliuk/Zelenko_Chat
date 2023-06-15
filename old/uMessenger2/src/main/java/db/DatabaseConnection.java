package db;


import MyAppInitializer.MyAppInitializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
public class DatabaseConnection {


    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("properties/database");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");

        MyAppInitializer.initialize();

        return DriverManager.getConnection(url, user, pass);
    }
}




/* 
    public static Connection getConnection() {
        if (dataSource == null) {
            String name = System.getenv("DATABASE_NAME");
            String host = System.getenv("DATABASE_HOST");
            String port = System.getenv("DATABASE_PORT");
            String user = System.getenv("DATABASE_NAME");
            String password = System.getenv("DATABASE_PASSWORD");

            HikariConfig config = new HikariConfig();
            config.setDataSourceClassName("org.postgresql.ds.PGSimpleDataSource");
            config.addDataSourceProperty("serverName", host);
            config.addDataSourceProperty("portNumber", port);
            config.addDataSourceProperty("databaseName", name);
            config.addDataSourceProperty("user", user);
            config.addDataSourceProperty("password", password);
            config.setMaximumPoolSize(20);
            dataSource = new HikariDataSource(config);
        }
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    */

