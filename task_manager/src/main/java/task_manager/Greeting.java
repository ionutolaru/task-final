package task_manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Greeting extends HttpServlet{
	
	/**
	 * Generated serial id
	 */
	private static final long serialVersionUID = -703980434469498486L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if(session.getAttribute("username")!=null){
			req.setAttribute("username", req.getParameter("username"));
			req.getRequestDispatcher("/jsp/Greeting.jsp").forward(req, resp);
		}
		else{
			req.getRequestDispatcher("/jsp/login.jsp").forward(req, resp);
		}
		
	    
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
