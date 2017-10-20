
package golunarproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author Sadat
 */
public class sqliteConnection {
    Connection c = null;
    Statement s = null;
    
    sqliteConnection(){
        try{
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("JDBC:sqlite:GSUREGISTRATION2.sqlite");
            System.out.println("Connection Success.");
            c.close();
        }catch (Exception e){
            System.out.println("Error connecting to server." + e.getMessage());
        }
    }
}
