package com.itlize.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.itlize.hibernate.demo.entity.Course;
import com.itlize.hibernate.demo.entity.Instructor;
import com.itlize.hibernate.demo.entity.InstructorDetail;
import com.itlize.hibernate.demo.entity.Student;

public class ReadInstructorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

// create session
Session session = factory.getCurrentSession();

try {			

session.beginTransaction();

// retrieve student based on the id: primary key
System.out.println("\nGetting instructor with id: " + 16);

// get instructor
Instructor myInstructor = session.get(Instructor.class, 16);

System.out.println("Get complete: " + myInstructor);

// commit the transaction
session.getTransaction().commit();

System.out.println("Done!");
}
finally {
factory.close();
}


	}
}


