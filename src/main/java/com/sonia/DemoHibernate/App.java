package com.sonia.DemoHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sonia.DemoHibernate.model.Book;
import com.sonia.DemoHibernate.model.User;

/**
 * Hibernate Examples
 *
 */
public class App {
	public static void main(String[] args) {

		/*
		 * Save Data
		 */

	User user = null;

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
				.addAnnotatedClass(User.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		
		user = session.get(User.class, 101);
		
		transaction.commit();
		
//		List<Book> books = user.getBook();
//		
//		for(Book book : books)
//		{
//			System.out.println(book.getBookId());
//		}

	}
}
