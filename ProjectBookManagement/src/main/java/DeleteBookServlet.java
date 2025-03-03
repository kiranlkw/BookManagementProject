

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


@WebServlet("/DeleteServlet")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 int bookId = Integer.parseInt(request.getParameter("bookId"));
		 
		 try {
				Connection conn = DatabaseHelper.getConnection();
				if(conn==null)
		        	   System.out.println("connection not established");
		        	else
		        		System.out.println("connection  established");
				
				 String sql = "DELETE FROM books WHERE id = ?";
				 PreparedStatement stmt = conn.prepareStatement(sql);
				 stmt.setInt(1, bookId);
	             stmt.executeUpdate();
			
		 }catch (SQLException e) {
				
				e.printStackTrace();
			}
		      
		      response.sendRedirect("ListBookServlet"); 
		
	}

}
