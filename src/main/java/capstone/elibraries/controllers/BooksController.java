package capstone.elibraries.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import capstone.elibraries.repositories.Books;
import capstone.elibraries.models.Book;
import org.springframework.ui.Model;

@Controller
public class BooksController {
    private Books books;

    public BooksController(Books books){
        this.books=books;
    }
    @GetMapping("/books")
    public String getBooks(Model model){
        model.addAttribute("books",books.findAll());
        return "index";
    }
    @GetMapping("/books/{id}")
    public String getOneBook(Model model, @PathVariable Long id){
        model.addAttribute("book",books.findOne(id));
        return "book";
    }
    @GetMapping("/books/create")
    public String createBook(Model model){
        model.addAttribute("book",new Book());
        return "books/create";
    }
}
