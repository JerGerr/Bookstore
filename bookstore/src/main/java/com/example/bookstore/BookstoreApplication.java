package com.example.bookstore;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookDemo(BookRepository repository, CategoryRepository repository2, UserRepository urepository) {
		return (args) -> {
			log.info("save a couple of books");
			repository2.save(new Category("Realism"));
			repository2.save(new Category("Political satire"));	

			repository.save(new Book("Ernest Hemmingway", "A Farewell to Arms", "1232323-21", 1929, 11.00, repository2.findByName("Realism").get(0)));
			repository.save(new Book("George Orwell", "Animal Farm", "2212343-5", 1945, 3.00, repository2.findByName("Political satire").get(0)));	
			
			// Create users: admin/admin user/user
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
								
				
				
			}

		};
		
		

	}
}
