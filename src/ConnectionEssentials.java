import java.sql.*;

public class ConnectionEssentials {
    private static final String URL = "jdbc:sqlite:src/Data Base/DB.db"; // database file

    public static Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(URL);
    }
}
