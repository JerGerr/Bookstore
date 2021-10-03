package com.example.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String authorName;
	private String bookName;
	private String ISBN;
	private int pubYear;
	private double Price;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	@JsonManagedReference
	private Category category;

	public Book() {}

	public Book(String authorName, String bookName, String ISBN, int pubYear, double Price, Category category) {
		super();
		this.authorName = authorName;
		this.bookName = bookName;
		this.ISBN = ISBN;
		this.pubYear = pubYear;
		this.Price = Price;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setaAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setPubYear(String ISBN) {
		this.ISBN = ISBN;
	}

	public int getPubYear() {
		return pubYear;
	}

	public void setPubYear(int pubYear) {
		this.pubYear = pubYear;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double Price) {
		this.Price = Price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() 
	{
		if (this.category != null)
			return "Book [id=" + id + ", authorName=" + authorName + ", bookName=" + bookName + ", ISBN=" + ISBN + ", pubYear=" + pubYear + ", Price" + Price + ", category =" + this.getCategory() + "]";
		else
			return "Book [id=" + id + ", authorName=" + authorName + ", bookName=" + bookName + ", ISBN=" + ISBN + ", pubYear=" + pubYear + ", Price" + Price + "]";
	}	
}