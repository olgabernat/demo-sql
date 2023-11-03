import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Utils {
    private static final Logger logger = LogManager.getLogger();

    public static void selectAll() {
        String sql = "SELECT * From Users";
        logger.info("Perform query" + sql);

        try (Connection conn = Connect.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            // loop through the result set
            while (rs.next()) {
                logger.info(rs.getInt("ID") + "\t" +
                        rs.getString("Name") + "\t" +
                        rs.getString("Password") + "\t" +
                        rs.getInt("IsAdmin"));
            }
        } catch (SQLException e) {
            logger.error("Error of query " + e.getMessage());
        }
    }

    public static void delete() {
        String sql = "DELETE FROM Users";
        logger.info("Perform query" + sql);

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error of query " + e.getMessage());
        }
    }

    public static void insert(int id, String name, String password, int isAdmin) {
        String sql = "INSERT INTO Users (ID, Name, Password, IsAdmin)VALUES(?,?,?,?)";
        logger.info("Perform query" + sql);

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            logger.info("ID = " + id + "\t" +
                    "Name = " + name + "\t" +
                    "Password = " + password + "\t" +
                    "IsAdmin = " + isAdmin);

            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, password);
            pstmt.setInt(4, isAdmin);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error of query " + e.getMessage());
        }
    }

    public static void delete1User(int id) {
        String sql = "DELETE FROM Users WHERE id = ?";
        logger.info("Perform query" + sql);

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            logger.info("ID = " + id);

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error of query " + e.getMessage());
        }
    }

    public static void update(int id, String name, String password) {
        String sql = "UPDATE Users SET name = ? , "
                + "password = ? "
                + "WHERE id = ?";
        logger.info("Perform query" + sql);

        try (Connection conn = Connect.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            logger.info("ID = " + id + "\t" +
                    "Name = " + name + "\t" +
                    "Password = " + password);

            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setString(2, password);
            pstmt.setInt(3, id);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error of query " + e);
        }
    }
}
