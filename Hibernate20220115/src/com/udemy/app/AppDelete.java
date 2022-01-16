package com.udemy.app;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.entity.Users;

public class AppDelete {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibetnate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
		Session session = factory.getCurrentSession();
		
		try {
			
			//Create Object of entrity Class type
			Users user = new Users();
			//start transaction
			session.beginTransaction();
			//perform operation
			user = session.get(Users.class, 2);
			System.out.println(user);
			session.delete(user);
			
			//commit transaction
			session.getTransaction().commit();
									
		} finally {
			
			session.close();
			factory.close();
		}
	}

}
