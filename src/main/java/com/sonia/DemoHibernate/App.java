package com.sonia.DemoHibernate;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sonia.DemoHibernate.model.Address;
import com.sonia.DemoHibernate.model.Customer;
import com.sonia.DemoHibernate.model.Employee;

/**
 * Hibernate Examples
 *
 */
public class App {
	public static void main(String[] args) {

		/*
		 * Save Data
		 */

		Address address = new Address();
		address.setCity("Pune");
		address.setState("Maharashtra");
		address.setCountry("India");

		Employee employee = new Employee();
		employee.setEmployeeId(1);
		employee.setEmployeeName("Kumari Sonia");
		employee.setEmployeeAddress(address);

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Serializable status = session.save(employee);
		transaction.commit();

		System.out.println("Data Saved " + status);

		/*
		 * Fetch Data
		 */

//		Customer cutomer = null;
//		Configuration configuration = new Configuration().configure("hibernate.cfg.xml")
//				.addAnnotatedClass(Customer.class);
//
//		SessionFactory sessionFactory = configuration.buildSessionFactory();
//
//		Session session = sessionFactory.openSession();
//
//		Transaction transaction = session.beginTransaction();
//		cutomer = session.get(Customer.class, 95);
//		transaction.commit();
//
//		System.out.println(cutomer);

	}
}
