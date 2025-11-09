package com.projekt.Online_Shop.dto;

import lombok.Data;

@Data
public class UserAccountDto {
    private Long userId;
    private String email;
    private String password;
    private String city;
    private String country;
    private String street;
    private String zipCode;
    private String avatarUrl;
    private String role;
}
