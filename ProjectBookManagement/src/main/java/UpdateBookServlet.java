

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


@WebServlet("/UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public UpdateBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 int bookId = Integer.parseInt(request.getParameter("bookId"));

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        try {
	            Connection conn = DatabaseHelper.getConnection();
	            if (conn == null) {
	                System.out.println("Connection not established");
	            } else {
	                System.out.println("Connection established");
	            }
	            
	            String sql = "SELECT * FROM books WHERE id = ?";
	            
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            
	            stmt.setInt(1, bookId);
	            
	            ResultSet rs = stmt.executeQuery();
	            
	            if(rs.next())
	            {
	            	 String title = rs.getString("title");
                     String author = rs.getString("author");
                     
                     out.println("<html>");
                     out.println("<head>");
                     out.println("<style>");
                     out.println("body { font-family: Arial, sans-serif; background-color: #f4f4f9; margin: 0; padding: 0; }");
                     out.println("h2 { text-align: center; color: #333; padding: 20px; }");
                     out.println("form { width: 50%; margin: 0 auto; max-width:300px; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }");
                     out.println("label { display: block; margin: 10px 0 5px; font-size: 16px; }");
                     out.println("input[type='text'] { width: 100%; padding: 10px; margin: 5px 0 15px 0; border: 1px solid #ccc; border-radius: 4px; font-size: 14px; }");
                     out.println("input[type='submit'] { width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 16px; }");
                     out.println("input[type='submit']:hover { background-color: #45a049; }");
                     
                     out.println("</style>");
                     out.println("</head>");
                     
                     
                     out.println("<body>");
                     
                     out.println("<h2>Update Book</h2>");
                     out.println("<form action='UpdateBookServlet' method='POST'>");
                     out.println("<input type='hidden' name='bookId' value='" + bookId + "'/>");
                     
                     
                     out.println("<label for='title'>Title:</label>");
                     out.println("<input type='text' id='title' name='title' value='" + title + "' required/><br/>");
                     out.println("<label for='author'>Author:</label>");
                     out.println("<input type='text' id='author' name='author' value='" + author + "' required/><br/>");
                     out.println("<input type='submit' value='Update Book'/>");
                     out.println("</form>");
                     out.println("</body>");
                     out.println("</html>");

	            }
	            
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int bookId = Integer.parseInt(request.getParameter("bookId"));
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        
	        try {
	            Connection conn = DatabaseHelper.getConnection();
	            if (conn == null) {
	                System.out.println("Connection not established");
	            } else {
	                System.out.println("Connection established");
	            }
	            
	            String sql = "UPDATE books SET title = ?, author = ? WHERE id = ?";
	            
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, title);
                stmt.setString(2, author);
                stmt.setInt(3, bookId);
                stmt.executeUpdate();
	            
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        response.sendRedirect("ListBookServlet"); 
	}

}
