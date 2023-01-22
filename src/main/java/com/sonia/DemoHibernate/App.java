package com.sonia.DemoHibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sonia.DemoHibernate.model.Customer;

/**
 * Hibernate Examples
 *
 */
public class App {
	public static void main(String[] args) {

		/*
		 * Save Data
		 */

//		Customer cutomer = new Customer();
//		cutomer.setCustomerName("Milan Bamaniya");
//		cutomer.setContactName("Milan");
//		cutomer.setAddress("Ahmedabad");
//		cutomer.setCity("Ahmedabaddd");
//		cutomer.setPostalCode("1234567898");
//		cutomer.setCountry("India");
//
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Customer.class);
//
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//		Session session = sessionFactory.openSession();
//
//		Transaction transaction = session.beginTransaction();
//		Serializable status = session.save(cutomer);
//		transaction.commit();
//
//		System.out.println("Data Saved " + status);

		/*
		 * Fetch Data
		 */

		Customer cutomer = null;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		cutomer = session.get(Customer.class, 95);
		transaction.commit();

		System.out.println(cutomer);

	}
}
