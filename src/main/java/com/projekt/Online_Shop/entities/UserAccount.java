package com.projekt.Online_Shop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class UserAccount  extends GenericEntity {

    @Column(unique=true)
    private String email;
    private String password;
    private String city;
    private String country;
    private String street;
    private String zipCode;
    private String avatarUrl;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

}
