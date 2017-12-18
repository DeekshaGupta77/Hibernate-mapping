package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.demo.entity.Instructor;
import com.hibernate.demo.entity.InstructorDetail;

 public class CreateDemo {

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
			
			Instructor tempInstructor = new Instructor("Sumit", "V", "sv@yahoo.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("youtube.com", "singing");
			
			
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			System.out.println("Saving Instructor and its details.....");
			session.save(tempInstructor);
			session.getTransaction().commit();
		}
		finally{
			factory.close();
		}
	}

}
