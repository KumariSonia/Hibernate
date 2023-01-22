package com.sonia.DemoHibernate.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	private int userId;
	private String userName;
	private String userAddress;
	@ManyToMany(mappedBy = "user", fetch = FetchType.EAGER) // Bydefault its lazy also it will fire two different query
															// if you want Book //EAGER wil fire one query but with left
															// out join with Book
	private List<Book> book = new ArrayList<Book>();

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userAddress=" + userAddress + ", book=" + book
				+ "]";
	}

}
