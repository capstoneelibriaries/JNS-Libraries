package capstone.elibraries.controllers;

import capstone.elibraries.models.Book;
import capstone.elibraries.repositories.Books;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BooksController {
    private Books books;

    public BooksController(Books books){
        this.books=books;
    }
    @GetMapping("/books")
    public String getbooks(Model model){
        model.addAttribute("books",books.findAll());
        return "index";
    }
    @GetMapping("/books/{id}")
    public String getOnebook(Model model, @PathVariable Long id){
        model.addAttribute("book",books.findOne(id));
        return "book";
    }
    @GetMapping("/books/create")
    public String createBook(Model model){
        model.addAttribute("book",new Book());
        return "books/create";
    }

}
