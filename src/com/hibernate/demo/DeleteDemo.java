package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo {

public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().
				configure("hibernate.cfg.xml").
				addAnnotatedClass(Instructor.class).
				addAnnotatedClass(InstructorDetail.class).
				buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try{
			/*Instructor tempInstructor = new Instructor("Adarsh", "V", "av@yahoo.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com", "coding");*/
			session.beginTransaction();
			
			int theId = 2;
			
			Instructor theI = session.get(Instructor.class, theId);
			
			System.out.println("Instructor with Id=2 found...." +theI);
			
			if(theI != null)
			{
				System.out.println("Deleting the Instructor.....");
				session.delete(theI);
			}
			
			
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

}
