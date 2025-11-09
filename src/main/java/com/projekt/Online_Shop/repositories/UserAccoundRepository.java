package com.projekt.Online_Shop.repositories;

import com.projekt.Online_Shop.entities.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccoundRepository extends JpaRepository <UserAccoundRepository,Long>{
    Optional<UserAccount> findByEmail(String email);


}
