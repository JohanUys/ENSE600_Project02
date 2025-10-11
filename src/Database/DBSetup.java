package Database;

import java.sql.*;

public class DBSetup {
    private static final String DB_URL = "jdbc:derby:gameDB;create=true";

    public static void initDatabase() {
    try (Connection conn = DriverManager.getConnection(DB_URL);
         Statement statement = conn.createStatement()) {

        try {
            statement.executeUpdate("CREATE TABLE ports (" +
                               "name VARCHAR(100) PRIMARY KEY, " +
                               "latitude INT, " +
                               "longitude INT" +
                               ")");
            System.out.println("Table 'ports' created successfully.");
        } catch (SQLException e) {
            if (e.getSQLState().equals("X0Y32")) {
                // "X0Y32" means Table already exists - this is fine
                System.out.println("Table 'ports' already exists.");
            } else {
                throw e; // Some other error - rethrow - this is not fine
            }
        }

        System.out.println("Database initialised successfully.");

    } catch (SQLException e) {
        System.err.println("Error initialising database:");
    }
}
}