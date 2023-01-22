package com.sonia.DemoHibernate;

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

		Book book1 = new Book();
		book1.setBookId(1);
		book1.setBootTitle("Good To Great");
		book1.setBookAuthor("xyzAuthor");

		Book book2 = new Book();
		book2.setBookId(2);
		book2.setBootTitle("Power of Thinking Big");
		book2.setBookAuthor("xyzAuthor");

		User user = new User();
		user.setUserId(101);
		user.setUserName("Sonia Singh");
		user.setUserAddress("Pune, India");
		user.getBook().add(book1);
		user.getBook().add(book2);

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
				.addAnnotatedClass(User.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(book1);
		session.save(book2);
		session.save(user);
		transaction.commit();

	}
}
