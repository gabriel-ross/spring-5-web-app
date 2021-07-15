package learning.gabeross.spring5webapp.controllers;

import learning.gabeross.spring5webapp.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        // Still a bit confused as to what exactly this is doing
        // and how it's different from @RequestMapping
        // I thought the attribute was the endpoint
        model.addAttribute("authors", authorRepository.findAll());

        return "authors/list";
    }
}
