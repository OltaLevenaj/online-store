package com.projekt.Online_Shop.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "categories")
public class Category extends GenericEntity {

    @Column(unique = true)
    private String name;
}
