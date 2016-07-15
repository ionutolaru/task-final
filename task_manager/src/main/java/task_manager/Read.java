package task_manager;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transaction;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entities.Proiecte;

/**
 * Servlet implementation class Read
 */
public class Read extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static SessionFactory factory;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Read() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/jsp/read.jsp").forward(request, response);	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Session session = factory.openSession();
	      org.hibernate.Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
			List proiectes = session.createQuery("FROM Proiecte").list(); 
	         for (Iterator iterator = proiectes.iterator(); iterator.hasNext();){
	            Proiecte proiecte = (Proiecte) iterator.next(); 
	            System.out.print("Project Name: " + proiecte.getProjectName()); 
	            System.out.print("  Project Description: " + proiecte.getProjectDescription()); 
	            System.out.println("  Date Create: " + proiecte.getDateCreated()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	}

}
