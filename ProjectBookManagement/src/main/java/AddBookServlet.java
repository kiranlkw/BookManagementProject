

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String title = request.getParameter("title");
	      String author = request.getParameter("author");
	      
	      
	      try {
			Connection conn = DatabaseHelper.getConnection();
			if(conn==null)
	        	   System.out.println("connection not established");
	        	else
	        		System.out.println("connection  established");
			
			String sql = "INSERT INTO books (title, author) VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			  stmt.setString(1, title);
              stmt.setString(2, author);
              stmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	      
	      response.sendRedirect("ListBookServlet"); 
	      
	}

}
