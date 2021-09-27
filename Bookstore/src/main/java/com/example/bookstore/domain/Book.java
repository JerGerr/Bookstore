package com.example.bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
	private String categoryName;

	@ManyToOne
	@JoinColumn(name = "book_category_id")
	private Category Category;

	public Book() {}

	public Book(String authorName, String bookName, String ISBN, int pubYear, double Price, String categoryName) {
		super();
		this.authorName = authorName;
		this.bookName = bookName;
		this.ISBN = ISBN;
		this.pubYear = pubYear;
		this.Price = Price;
		this.categoryName=categoryName;
	}

	public Book(String categoryName, Category Category) {
		this.categoryName = categoryName;
		this.Category = Category;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category getCategory() {
		return Category;
	}

	public void setCategory(Category Category) {
		this.Category = Category;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", authorName=" + authorName + ", bookName=" + bookName + ", ISBN=" + ISBN + ", pubYear=" + pubYear + ", Price" + Price + ", categoryName=" + categoryName + "]";
	}
}