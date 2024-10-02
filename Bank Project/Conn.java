import java.sql.*;

public class Conn {
    Connection c=null;
    Statement s=null;

    public Conn() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver"); // Make sure this line is included

            // Establish the connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/signup1", "root", "kartik@123");

            // Create a statement
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }
}
