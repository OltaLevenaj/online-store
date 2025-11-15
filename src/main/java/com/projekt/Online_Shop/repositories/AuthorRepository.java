package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {

    List<Author>findAllByFirstname(String firstname);
    List<Author>findAllByLastname(String lastname);
}
