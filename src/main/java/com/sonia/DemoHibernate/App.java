package com.sonia.DemoHibernate;

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
		Customer customer = null;
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();

		customer = session.get(Customer.class, 56);
		System.out.println(customer);

		customer = session.get(Customer.class, 56);  //will not fire query again
		System.out.println(customer);

		transaction.commit();

	}
}
