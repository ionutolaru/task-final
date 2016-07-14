package task_manager;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Select
 */
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
        PrintWriter out = res.getWriter();
	


        Connection con=null;
        Statement stmt=null;
        
        try
        {
              Class.forName("com.mysql.jdbc.Driver").newInstance();
              con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/task_manager","root","" );
              System.out.println("Connected to the database");
              String query = "select * from user";
              System.out.println("query " + query);
              stmt=con.createStatement();
              ResultSet  rs = stmt.executeQuery(query);
              
              out.print("<table>");
             
              while(rs.next())
              {
             	String id = rs.getObject("id_user").toString();
             	String user = rs.getObject("username").toString();
             	String password = rs.getObject("password").toString();
             	
             	out.print("<tr><td>" + id  + "</td>");
                 out.print("<td>" + user +"</td>");
                 out.print("<td>" + password +"</td>");
                 out.print("<td> <a href=http://localhost:8080/taskmanager/Delete?u="+id+">Delete</a> </td>");
                 out.print("<br>");
              }
              out.print(	
             		 "</table>\n"
             		+"<br><br>"
             		+ "<a href=http://localhost:8080/task_manager/jsp/select.jsp></a>\n"
             		+"</body>\n"
             		+"</html>\n");
              
              con.close();
              System.out.println("Disconnected from database");
          } catch (Exception e) {
            e.printStackTrace();
            }
    }
}