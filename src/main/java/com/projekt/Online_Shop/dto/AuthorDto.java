package com.projekt.Online_Shop.dto;

import com.projekt.Online_Shop.entities.Role;
import lombok.Data;

import java.util.List;

@Data
public class AuthorDto {
    private Long id;
    private String firstName;
    private String lastName;


private List<Long>productIds;



}
