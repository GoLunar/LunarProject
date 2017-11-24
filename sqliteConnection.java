



import java.sql.*;

public class sqliteConnection {

    public static Connection dbconnector() {
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:/Users/myuniverese/Downloads/LunarProject-Sadat/GoLunarProject/database/school.sqlite");
           // conn.setAutoCommit(true);
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
}
