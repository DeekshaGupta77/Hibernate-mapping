package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

public class DeleteInstructorDetailDemo {

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
			int theId =3;
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			System.out.println("Instructor Detail is:" +tempInstructorDetail );
			
			System.out.println("Associated Instructor is: " +tempInstructorDetail.getInstructor());
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done.....!!!!!!");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally{
			session.close();
			factory.close();
		}
	}

}
