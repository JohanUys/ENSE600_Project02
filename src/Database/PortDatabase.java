package Database;

import LOGIC.Port;
import java.sql.*;
import java.util.HashMap;

// Methods to interact with the database storing the port objects
public class PortDatabase {
    // JDBC URL for embedded derby database
    private static final String DB_URL = "jdbc:derby:gameDB;create=true";

    // Checks whether any ports currently exist in the ports table
    public static boolean portsExist() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM ports")) {

            rs.next();
            return rs.getInt(1) > 0;

        } catch (SQLException e) {
            return false;
        }
    }

    // Inserts a new port record into the ports table
    public static void insertPort(Port port) {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement ps = conn.prepareStatement(
                     "INSERT INTO ports (name, latitude, longitude) VALUES (?, ?, ?)")) {

            ps.setString(1, port.getName());
            ps.setInt(2, port.getLatitude());
            ps.setInt(3, port.getLongitude());
            ps.executeUpdate();

        } catch (SQLException e) {
        }
    }
    
    // Deletes all the ports in the port table
    public static void clearPorts() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement()) {
            statement.executeUpdate("DELETE FROM ports");
        } catch (SQLException e) {
            System.err.println("Error clearing ports: " + e.getMessage());
        }
    }
    
    // Load all ports stored in the port table
    public static HashMap<String, Port> loadPorts() {
        HashMap<String, Port> ports = new HashMap<>();

        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM ports")) {

            while (rs.next()) {
                String name = rs.getString("name");
                int latitude = rs.getInt("latitude");
                int longitude = rs.getInt("longitude");

                Port port = new Port(name, latitude, longitude);
                ports.put(name, port);
            }

        } catch (SQLException e) {
            System.err.println("Error loading ports: " + e.getMessage());
        }

        return ports;
    }
}