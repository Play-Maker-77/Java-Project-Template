import java.sql.*;

public class CheckTables {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:src/Data Base/DB.db"; // make sure path matches your DB file

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            System.out.println("Connected!");

            // Query the system table for all tables
            ResultSet rs = stmt.executeQuery(
                    "SELECT name FROM sqlite_master WHERE type='table';"
            );

            System.out.println("Tables in database:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}