package com.projekt.Online_Shop.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "authors")

public class Author extends GenericEntity{


    private String firstname;
    private String lastname;
    @OneToMany
    private List< Product> products;
}

