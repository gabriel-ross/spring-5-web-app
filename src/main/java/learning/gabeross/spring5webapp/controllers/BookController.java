package learning.gabeross.spring5webapp.controllers;

import learning.gabeross.spring5webapp.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    // Here we're telling spring to inject a book repo
    // so that when spring instantiates this controller it will inject
    // an instance of a book repo
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        // The model is what is going to be returned to the view

        model.addAttribute("books", bookRepository.findAll());

        // this is the view name that it is returning back
        // we're telling it to return the list template in the directory "books"
        // I guess it auto-looks in template directory and we're telling it to look
        // for a file named "list" in the directory "books" in the directory "templates"
        return "books/list";
    }
}
