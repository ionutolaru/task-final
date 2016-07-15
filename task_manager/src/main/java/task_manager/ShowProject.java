package task_manager;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

public class ShowProject extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException
    {
		//HttpSession session = request.getSession();
    	//if(session.getAttribute("username")!=null)
    	//{   
    	//	request.setAttribute("username", request.getParameter("firstname"));
    		//request.getRequestDispatcher("/jsp/Greeting.jsp").forward(request, response);
    	//}
    	//else	request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		
        PrintWriter out = res.getWriter();

        Connection con=null;
        Statement stmt=null;

        try 
        {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:8080/proiecte","root","");
            System.out.println("Connected to the database");
       
            String query = "select * from proiecte";
            System.out.println("query " + query);
            stmt = con.createStatement();
            ResultSet  rs = stmt.executeQuery(query);
           
            int i=1;
            out.print("<table>"
            		+ "<tr>	<th>Nr.</th> <th>Project Name</th><th>Project Description</th><th>Data Created</th></tr>");
	        while(rs.next())
	        {
	        	String id = rs.getObject("id_project").toString();
	        	String name = rs.getObject("project_name").toString();
	        	String desc = rs.getObject("project_description").toString();
	        	String date = rs.getObject("dateCreated").toString();;
	        	
	        	out.print("<tr><td>" + (i++)  + "</td>");
	            out.print("<td>" + name +"</td>");
	            out.print("<td>" + desc +"</td>");
	            out.print("<td>" + date +"</td>");

	        }
	        out.print(	
        		 "</table>\n"
        		+"<br><br>"
        		+ "<a href=http://localhost:8080/task_manager/ShowProject>Back</a>\n"
        		+"</body>\n"
        		+"</html>\n");
         
	        con.close();
	        System.out.println("Disconnected from database");
        } 
        catch (Exception e) 
        {
          e.printStackTrace();
         }  
    }
}