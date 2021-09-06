package com.example.bookstore.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antti.bookstore.domain.Book;
import com.antti.bookstore.domain.BookRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Controller
public class BookController {

	@Autowired
	BookRepository repository;

	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String bookStoreFront(Model model) {

		model.addAttribute("book", new Book());
		model.addAttribute("books", repository.findAll());
		return "books";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book, BindingResult errors, Model model) {

		repository.save(book);
		return "redirect:booklist";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long id, Model model) {

		repository.delete(id);
		return "redirect:../booklist";
	}

	@JsonIgnore
	@RequestMapping(value = "/books")
	public @ResponseBody List<Book> booksJSON() {
		return (List<Book>) repository.findAll();
	}

	@JsonIgnore
	@RequestMapping(value = "/books/{id}")
	public @ResponseBody Book findBookJson(@PathVariable("id") long id) {
		return repository.findOne(id);
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/bb")
	public String reactStart() {
		return "index.html";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/login?logout";
	}

}