package task_manager;

	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.Transaction;
	import org.hibernate.cfg.Configuration;

import entities.Tabel;
	public class Main {
		private static SessionFactory sessionFactory;
		public static void main(String[] args) {
			try {
				sessionFactory = new Configuration().configure("hibernate.cfg.xml")
						.buildSessionFactory();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			Session session = sessionFactory.openSession();
			
			//Inserting Student Records
			Transaction tx = session.beginTransaction();
			Tabel student = new Tabel();
			student.setNume("Ra");
			session.save(student);
			tx.commit();
					
			System.out.println("Inserted Student details");
			
			/*Selecting Student Records
			Object object = session.load(Student.class, "Raj");
			Student stud = (Student) object;
			System.out.println("Selected Student details");
			System.out.println("Student Name: " + stud.getName());
			System.out.println("Student Standard: " + stud.getStandard());
			//Update Student Details
			System.out.println("Updating Student details ");
			Transaction tx1 = session.beginTransaction();
			stud.setStandard("Plus one");
			session.update(stud);
			tx1.commit();
			
			Object object1 = session.load(Student.class, "Raj");
			Student stud1 = (Student) object1;
			System.out.println("Student details after updating");
			System.out.println("Student Name: " + stud1.getName());
			System.out.println("Student Standard: " + stud1.getStandard());
			
			System.out.println("Deleting Student records");
			Transaction tx2 = session.beginTransaction();
			
			//Deleting Student records
			session.delete(stud1);
			tx2.commit();
			System.out.println("Student Deleted successfully");*/
			if (session != null)
				session.close();
		}
	
}
