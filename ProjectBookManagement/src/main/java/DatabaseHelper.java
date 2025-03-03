import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {
	
	 private static final String URL = "jdbc:mysql://localhost/book_db";
	    private static final String USER = "root";  // Replace with your MySQL username
	    private static final String PASSWORD = "root";  // Replace with your MySQL password

	    public static Connection getConnection() throws SQLException {
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
}
