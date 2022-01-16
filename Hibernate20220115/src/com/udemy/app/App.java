package com.udemy.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.hibernate.entity.Users;

public class App {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibetnate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Users user = new Users("Anu", "Anu", "Anu", "Gopal");
			Users user1 = new Users("Isu", "Isu", "Isu", "Gopal");
			Users user2 = new Users("Ishaani", "Ishaani", "Ishaani", "Gopal");
			session.beginTransaction();
			//session.save(user2);
			//session.save(user1);
			session.save(user);
			session.getTransaction().commit();
			
			System.out.println("Row Added !!");
			
			
		} finally {
			
			session.close();
			factory.close();
		}

	}

}
