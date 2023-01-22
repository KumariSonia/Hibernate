package com.sonia.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		Customer customer = null;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session1 = sessionFactory.openSession();

		session1.beginTransaction();

		customer = session1.get(Customer.class, 56);

		System.out.println(customer);

		session1.getTransaction().commit();
		session1.close();

		Session session2 = sessionFactory.openSession();

		session2.beginTransaction();

		customer = session2.get(Customer.class, 56);
		System.out.println(customer);

		session2.getTransaction().commit();
		session2.close();

	}
}
