package week11hw09.util.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String url = "jdbc:postgresql://localhost:5432/crud";
    private static final String username = "postgres";
    private static final String pass = "J@h@n910";
    Connection connection;

    public DBUtil() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, pass);
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, pass);
        return connection;
    }


    public void setConnection() {
        this.connection = connection;
    }
}
