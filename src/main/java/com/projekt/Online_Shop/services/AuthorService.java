package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.dto.AuthorDto;
import com.projekt.Online_Shop.entities.Author;
import com.projekt.Online_Shop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    public List<Author> getAllAuthors;
    @Autowired
    private AuthorRepository authorRepository;

    public Author findAuthorById(Long id) {
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author Not Found"));
    }

    public List<Author> findAuthorByFirstName(String firstName) {
        return authorRepository.findAllByFirstname(firstName);
    }
    public List<Author> findAuthorByLastName(String lastName) {
        return authorRepository.findAllByLastname(lastName);
    }


    public Author addAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstname(authorDto.getFirstName());
        author.setLastname(authorDto.getLastName());
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, AuthorDto authorDto) {
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if (optionalAuthor.isPresent()) {
            Author author = optionalAuthor.get();
            author.setFirstname(authorDto.getFirstName());
            author.setLastname(authorDto.getLastName());
            return authorRepository.save(author);
        } else
            throw new RuntimeException("Author Not Found");
    }


    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}







