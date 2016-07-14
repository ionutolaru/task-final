package task_manager;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;

public class Insert extends HttpServlet
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        PrintWriter out = res.getWriter();
	
        String username=req.getParameter("username");
        String password=req.getParameter("password");

        Connection con=null;
        Statement stmt=null;
        
        try
        {
              Class.forName("com.mysql.jdbc.Driver");
              con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","" );
              stmt=con.createStatement();
              int i = stmt.executeUpdate("insert into user(username,password) values('"+username+"','"+password+"')");
              if(i>0)
              {
            	  System.out.println("Inserted Successfully: " + username + " " + password);
            	  res.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
                  res.setHeader("Location", "http://localhost:3306/Task_manager/jsp/insert.jsp"); 
              }
              else
            	  System.out.println("Insert Unsuccessful");
        }
        catch(Exception e)
        {
          out.println(e);       
        }      
    }
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}

