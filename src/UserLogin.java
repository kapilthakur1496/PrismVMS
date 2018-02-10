
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daniel.util.DbUtil;

public class UserLogin extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Connection connection;

	public   UserLogin()
	{
		connection = DbUtil.getConnection();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	  
		 	java.sql.Statement userDetailSt = null; 
	        java.sql.ResultSet userDetailRs = null; 
	        PrintWriter out;
 
		try	{
				out = response.getWriter(); 
				String username = request.getParameter("email");
				String password = request.getParameter("password");
				  
				userDetailSt = connection.createStatement();			
				userDetailRs = userDetailSt.executeQuery("select * from customer where email='"+username+"' and password='"+password+"'");
				
				if (userDetailRs.next()) {	
					String userId=userDetailRs.getString("id");
					 
					String userName=userDetailRs.getString("name"); 
					HttpSession session = request.getSession(); 
					session.setAttribute("userId", userId);
					session.setAttribute("userName", userName);  
					session.setMaxInactiveInterval(1800); 
					response.sendRedirect("index.jsp"); 
				}
				else
				{ 
					response.sendRedirect("userLogin.jsp?msg3=fail");
				}
			}
		 catch(SQLException se){
           se.printStackTrace();
        }
        
        catch (NullPointerException e) {
     	   e.printStackTrace();
     	  }
        catch(Exception e){
           e.printStackTrace();
        }
       finally{
       	 
			if(userDetailSt!=null)
				try {
					userDetailSt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			if(userDetailRs!=null)
				try {
					userDetailRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
       	} 
	}

}