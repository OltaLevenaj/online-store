package com.projekt.Online_Shop.controller;

import com.projekt.Online_Shop.dto.AuthorDto;
import com.projekt.Online_Shop.entities.Author;
import com.projekt.Online_Shop.entities.Category;
import com.projekt.Online_Shop.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable Long id) {
        return authorService.findAuthorById(id);
    }

    @PostMapping("/create")
    public Author addAuthor(@RequestBody AuthorDto authorDto) {
        return authorService.addAuthor(authorDto);
    }

    @PutMapping("/update/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody AuthorDto authorDto) {
        return authorService.updateAuthor(id, authorDto);
    }
    @GetMapping("/search")
    public List<Author>searchByFirstName(@RequestParam(required = false) String firstname,
                                         @RequestParam(required = false) String lastname) {
        if (firstname != null)
            return authorService.findAuthorByFirstName(firstname);
        else if (lastname != null)
            return authorService.findAuthorByLastName(lastname);
        else
            return new ArrayList<>();
    }
}

