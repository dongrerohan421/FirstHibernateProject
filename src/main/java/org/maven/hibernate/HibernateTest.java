package org.maven.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.maven.hibernate.FirstHibernateProject.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		user.setUserId(1);
		user.setUserName("First User");
		user.setAddress("First user address");
		user.setJoinedDate(new Date());
		user.setDescription("Description of First User.");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		user =null;
		
		// second time there is no need to create SessionFactory
		// create new session and begin transaction.
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User name retrieved is "+user.getUserName());
	}

}
