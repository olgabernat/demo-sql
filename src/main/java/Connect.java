import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class Connect {
    private static final Logger logger = LogManager.getLogger();
    public static Connection connect() {
        String url = "jdbc:sqlite:C:\\db\\demo-db2.db";
        logger.info("Adress to DateBase: " + url);
        Connection conn = null;
        try {
            logger.info("Connect to DB");
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            logger.error("Error of connection " + e.getMessage());
        }
        return conn;
    }
}
