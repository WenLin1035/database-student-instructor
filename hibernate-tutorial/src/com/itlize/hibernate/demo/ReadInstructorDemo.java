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
// create a student object
System.out.println("Creating new instructor object...");
Instructor tempInstructor = 
new Instructor("Joe", "YYYee", "Joee@itlize.com");

InstructorDetail tempInstructorDetail =
new InstructorDetail(
		"http://www.youtube.com",
		"Playing games");

//associate the objects
tempInstructor.setInstructorDetail(tempInstructorDetail);
			
// start a transaction
session.beginTransaction();

// save the instructor object
System.out.println("Saving instructor: " + tempInstructor);
session.save(tempInstructor);

// commit transaction
session.getTransaction().commit();

// find out the instructor's id: primary key
System.out.println("Saved instructor. Generated id: " + tempInstructor.getId());

// now get a new session and start transaction
session = factory.getCurrentSession();
session.beginTransaction();

// retrieve student based on the id: primary key
System.out.println("\nGetting instructor with id: " + tempInstructor.getId());

Instructor myInstructor = session.get(Instructor.class, tempInstructor.getId());

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


