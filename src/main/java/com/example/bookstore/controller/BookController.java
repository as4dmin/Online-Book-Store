package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String listBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/books";
    }
    @GetMapping("/books/add")
    public String showAddBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/books/add")
    public String addBook(@ModelAttribute Book book) {
        bookService.saveBook(book);
        return "redirect:/books";
    }


}
