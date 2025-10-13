package Database;

import java.sql.*;

public class DBSetup {
    // JBDC URL for embedded derby database
    private static final String DB_URL = "jdbc:derby:gameDB;create=true";

    public static void initDatabase() {
    try (Connection conn = DriverManager.getConnection(DB_URL);
         Statement statement = conn.createStatement()) {

        // Create ports table
        try {
            statement.executeUpdate("CREATE TABLE ports (" +
                                   "name VARCHAR(100) PRIMARY KEY, " +
                                   "latitude INT, " +
                                   "longitude INT" +
                                   ")");
            System.out.println("Table 'ports' created successfully.");
        } catch (SQLException e) {
            // "X0Y32" means Table already exists - this is fine
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("Table 'ports' already exists.");
            } else {
                System.err.println("Unexpected error creating 'ports' table: " + e.getMessage());
                throw e; // Some other error - rethrow - this is not fine
            }
        }  

        // Create wind table
        try {
            statement.executeUpdate("CREATE TABLE wind (" +
                                   "id INT PRIMARY KEY, " +
                                   "direction VARCHAR(20), " +
                                   "speed INT" +
                                   ")");
            System.out.println("Table 'wind' created successfully.");
        } catch (SQLException e) {
           // "X0Y32" means Table already exists - this is fine
            if (e.getSQLState().equals("X0Y32")) {
                System.out.println("Table 'wind' already exists.");
            } else {
                System.err.println("Unexpected error creating 'wind' table: " + e.getMessage());
                throw e; // Some other error - rethrow - this is not fine
            }
        }

        System.out.println("Database initialised successfully.");

        } catch (SQLException e) {
            System.err.println("Error initialising database: " + e.getMessage());
        }
    }
}