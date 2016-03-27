package org.maven.hibernate;

import org.javabrains.maven.hibernate.FirstHibernateProject.Address;
//import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.maven.hibernate.FirstHibernateProject.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
		
		Address addr = new Address();
		addr.setStreet("Street name");
		addr.setCity("city name");
		addr.setState("state name");
		addr.setPincode("10001");
		
		user.setHomeAddress(addr);	
		
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street name");
		addr2.setCity("Second city name");
		addr2.setState("Second state name");
		addr2.setPincode("20002");
		
		user.setOfficeAddress(addr2);
		
		
		/*UserDetails user2 = new UserDetails();
		//user.setUserId(1);
		user2.setUserName("Second User");
		user2.setAddress("Second user address");
		user2.setJoinedDate(new Date());
		user2.setDescription("Description of Second User.");*/

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		//session.save(user2);
		session.getTransaction().commit();
		session.close();
		
		/*
		user =null;
		user2 =null;
		
		// second time there is no need to create SessionFactory
		// create new session and begin transaction.
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1); // will retrieve record which has id 1
		System.out.println("User name retrieved is "+user.getUserName());
		
		user2 = (UserDetails)session.get(UserDetails.class, 2); // will retrieve record which has id 1
		System.out.println("User name retrieved is "+user2.getUserName());
		*/
	}

}
