

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/*
@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        Statement stmt=null;
	        ResultSet rs =null;
	        
	        try {
				Connection conn = DatabaseHelper.getConnection();
				
				 if (conn == null)
		                System.out.println("connection not established");
		            else
		                System.out.println("connection established");
				 
				 String sql = "SELECT * FROM books";
				 
				stmt = conn.createStatement();
				rs= stmt.executeQuery(sql);
				
				out.println("<html><body>");
                out.println("<h2>List of Books</h2>");
                out.println("<table border='1'><tr><th>Title</th><th>Author</th></tr>");                
                while(rs.next())
                {
                	  out.println("<tr>");
                      out.println("<td>" + rs.getString("title") + "</td>");
                      out.println("<td>" + rs.getString("author") + "</td>");
                      out.println("</tr>");
                      
                }                
                out.println("</table>");
                out.println("</body></html>");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}

}

*/



@WebServlet("/ListBookServlet")
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		    response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        Statement stmt=null;
	        ResultSet rs =null;
	        
	        try {
				Connection conn = DatabaseHelper.getConnection();
				
				 if (conn == null)
		                System.out.println("connection not established");
		            else
		                System.out.println("connection established");
				 
				 String sql = "SELECT * FROM books";
				 
				stmt = conn.createStatement();
				rs= stmt.executeQuery(sql);
				
				out.println("<html><body>");
                out.println("<h2>List of Books</h2>");
                out.println("<table border='1'><tr><th>Title</th><th>Author</th><th>Actions</th></tr>");                
                while(rs.next())
                {
                	  int bookId = rs.getInt("id"); 
                	  out.println("<tr>");
                      out.println("<td>" + rs.getString("title") + "</td>");
                      out.println("<td>" + rs.getString("author") + "</td>");
                      out.println("<td>");
                      
                      out.println("<form action='DeleteServlet' method='POST' style='display:inline;'>");
                      out.println("<input type='hidden' name='bookId' value='" + bookId + "'/>");
                      out.println("<input type='submit' value='Delete'/>");
                      out.println("</form>");
                      
                      out.println("<form action='UpdateBookServlet' method='GET' style='display:inline;'>");
                      out.println("<input type='hidden' name='bookId' value='" + bookId + "'/>");
                      out.println("<input type='submit' value='Update'/>");
                      out.println("</form>");
                      
                      
                      out.println("</td>");
                      
                      
                      out.println("</tr>");
                      
                }                
                out.println("</table>");
                out.println("</body></html>");
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}

}