package com.sonia.DemoHibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	private int bookId;
	private String bootTitle;
	private String bookAuthor;

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

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bootTitle=" + bootTitle + ", bookAuthor=" + bookAuthor + "]";
	}

}