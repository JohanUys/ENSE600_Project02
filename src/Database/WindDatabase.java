package Database;

import LOGIC.Direction;
import LOGIC.Wind;
import java.sql.*;

// Methods to interact with the database storing the wind objects
public class WindDatabase {
    // JDBC URL for embedded derby database
    private static final String DB_URL = "jdbc:derby:gameDB;create=true";   

    // Checks whether a wind record exists in the database.
    public static boolean windExists() {
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM wind WHERE id = 1")) {

            rs.next();
            // If count > 0, a record exists
            return rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Error checking if wind exists: " + e.getMessage());
            return false;
        }
    }

    // Saves current wind data to database
    public static void saveWind(Wind wind) {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {

            // First, try to update existing row
            try (PreparedStatement updatePs = conn.prepareStatement(
                    "UPDATE wind SET direction = ?, speed = ? WHERE id = 1")) {

                updatePs.setString(1, wind.getDirection().name());
                updatePs.setInt(2, wind.getSpeed());

                int rowsAffected = updatePs.executeUpdate();

                // If no row was updated, insert a new one
                if (rowsAffected == 0) {
                    try (PreparedStatement insertPs = conn.prepareStatement(
                            "INSERT INTO wind (id, direction, speed) VALUES (1, ?, ?)")) {

                        insertPs.setString(1, wind.getDirection().name());
                        insertPs.setInt(2, wind.getSpeed());
                        insertPs.executeUpdate();
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error saving wind: " + e.getMessage());
        }
    }

    // Loads stored wind data from database
    public static Wind loadWind() {
        Wind wind = null;
        try (Connection conn = DriverManager.getConnection(DB_URL);
             Statement statement = conn.createStatement();
             ResultSet rs = statement.executeQuery("SELECT direction, speed FROM wind WHERE id=1")) {
            if (rs.next()) {
                Direction dir = Direction.valueOf(rs.getString("direction"));
                int speed = rs.getInt("speed");
                wind = new Wind();
                wind.setDirection(dir);
                wind.setSpeed(speed);
            }
        } catch (SQLException e) {
            System.err.println("Error loading wind: " + e.getMessage());
        }
        return wind;
    }
}
