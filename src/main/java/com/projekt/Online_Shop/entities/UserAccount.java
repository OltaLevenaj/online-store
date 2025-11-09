package com.projekt.Online_Shop.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="users")
public class UserAccount  extends GenericEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    private String email;
    private String password;
    private String city;
    private String country;
    private String street;
    private String zipCode;
    private String avatarUrl;

    @Enumerated(EnumType.STRING)
    private MessageChannelPreference messageChannelPreference;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public enum MessageChannelPreference {
        STANDARD_MAIL,
        EMAIL
    }

}
