package com.sonia.DemoHibernate;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
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

		/*
		 * getting list address and city of Customers using hql
		 */

//		Query query = session.createQuery("select address,city from Customer");
//
//		List<Object[]> objects = query.list();
//		for (Object[] object : objects) {
//			System.out.println(object[0] + " " + object[1]);
//		}

		/*
		 * getting sum of ids using hql
		 */
//		int b =10;
//
//		Query query = session.createQuery("select sum(customerID) from Customer c where c.customerID> :b");
//		query.setParameter("b", b);
//		Object sum = query.uniqueResult();
//		System.out.println(sum);
//
//		session.getTransaction().commit();
//		session.close();
		
		/*
		 * getting Customer using sql or native queries
		 */
		
//		SQLQuery query = session.createSQLQuery("select * from Customer where customerID>50");
//		query.addEntity(Customer.class);
//		List<Customer> customers = query.list();
//		
//		for(Customer customer : customers)
//		{
//			System.out.println(customer);
//		}
		
		/*
		 * getting coulumns of Customer using sql or native queries
		 */
		
		SQLQuery query = session.createSQLQuery("select address,city from Customer where customerID>50");
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List customers = query.list();
		
		for(Object obj : customers)
		{
			Map map = (Map)obj;
			System.out.println(map.get("address")+" "+map.get("city"));
		}
			

	}
}
