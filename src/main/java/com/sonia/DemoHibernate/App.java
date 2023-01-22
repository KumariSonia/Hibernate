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
		
		Book book3 = new Book();
		book3.setBookId(3);
		book3.setBootTitle("magic of Thinking Big");
		book3.setBookAuthor("xyzAuthor");

		User user1 = new User();
		user1.setUserId(101);
		user1.setUserName("Sonia Singh");
		user1.setUserAddress("Pune, India");
		user1.getBook().add(book1);
		user1.getBook().add(book2);
		
		User user2 = new User();
		user2.setUserId(102);
		user2.setUserName("Milan Bamaniya");
		user2.setUserAddress("Gujarat, India");
		user2.getBook().add(book1);
		user2.getBook().add(book3);
		
		
		book1.getUser().add(user2);
		book1.getUser().add(user1);
		book2.getUser().add(user1);
		book3.getUser().add(user2);

		Configuration configuration = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
				.addAnnotatedClass(User.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		session.save(book1);
		session.save(book2);
		session.save(book3);
		session.save(user1);
		session.save(user2);
		transaction.commit();

	}
}
