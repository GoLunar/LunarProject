package golunarproject;



import java.sql.*;

public class sqliteConnection {

    public static Connection dbconnector() {
        try {

            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:./database/schoolt.sqlite");
            //conn.setAutoCommit(false);
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
}
