package com.example.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	
	private String title;
	private String author;
	private String isbn;

	private double price;
	private int year;
	
	/*
	public Book(String author, String title, String isbn, double price, int year) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.price = price;
		this.year = year;
	}
	*/
	
	public Book(String author, String title, String isbn, int year) {
		super();
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.year = year;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", isbn=" + isbn
				+ ", price=" + price + ", year=" + year + "]";
	}

}