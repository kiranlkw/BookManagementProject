

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
       
    }

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		   String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        if (username.equals("admin") && password.equals("admin123")) {
	            
	            response.sendRedirect("AddBook.html");
	        } else {
	          
	            response.sendRedirect("loginfailed.html");
	        }
	}

}
