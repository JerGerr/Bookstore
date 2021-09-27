package com.example.bookstore.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "book_category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long categoryid;
	private String categoryName;
	
	@OneToMany(mappedBy = "Category", cascade = CascadeType.ALL)
    private Set<Book> books;
	
	 public Category() {}

		public Category(String categoryName) {
			super();
			this.categoryName=categoryName;
		}

		public Long getCategoryid() {
			return categoryid;
		}

		public void setCategoryid(Long categoryid) {
			this.categoryid = categoryid;
		}
		
		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}
		
	    public Set<Book> getBooks() {
	        return books;
	    }

	    public void setBooks(Set<Book> books) {
	        this.books = books;
	    }
		
		@Override
		public String toString() {
			return "Category [categoryid=" + categoryid + ", categoryName=" + categoryName + "]";
		}
	
}
