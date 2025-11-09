package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.entities.Author;
import com.projekt.Online_Shop.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
   private AuthorRepository authorRepository;


    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthor(Author authorDetails){
        return authorRepository.save(authorDetails);
    }
    public void deleteAuthor(Author authorDetails){
        authorRepository.delete(authorDetails);
    }
    public Author findAuthorById(int id){
        return authorRepository.findById(id).orElseThrow(()-> new RuntimeException("Author Not Found"));
    }
    public List<Author>findAllAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthorByName(String name){
        String search = "%".concat(name).concat("%");
        return authorRepository.findByName(name);
    }

    }







