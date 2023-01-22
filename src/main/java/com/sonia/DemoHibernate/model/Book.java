package com.sonia.DemoHibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	private int bookId;
	private String bootTitle;
	private String bookAuthor;

	@ManyToMany
	private List<User> user = new ArrayList<User>();

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBootTitle() {
		return bootTitle;
	}

	public void setBootTitle(String bootTitle) {
		this.bootTitle = bootTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bootTitle=" + bootTitle + ", bookAuthor=" + bookAuthor + ", user=" + user
				+ "]";
	}

}