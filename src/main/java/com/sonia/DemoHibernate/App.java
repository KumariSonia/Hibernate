package com.sonia.DemoHibernate;

import java.util.List;

import org.hibernate.Query;
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

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Query query = session.createQuery("from Customer");

		List<Customer> customers = query.list();
		for (Customer customer : customers) {
			System.out.println(customer);
		}

		session.getTransaction().commit();
		session.close();

	}
}
