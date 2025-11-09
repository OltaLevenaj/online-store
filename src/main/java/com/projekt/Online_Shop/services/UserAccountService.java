package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.dto.UserAccountDto;
import com.projekt.Online_Shop.entities.GenericEntity;
import com.projekt.Online_Shop.entities.UserAccount;
import com.projekt.Online_Shop.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService {
    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleService roleService;

    public UserAccount create(UserAccountDto userAccount) {
        if (userAccount.getEmail() != null) {
            if (userAccountRepository.
                    existsByEmail((userAccount.getEmail()))) {
                throw new RuntimeException("Email already exists");
            }
        } else {
            throw new RuntimeException("Email does not have a value");
        }
        UserAccount user = new UserAccount();
        user.setEmail(userAccount.getEmail());
        user.setPassword(passwordEncoder.encode(userAccount.getPassword()));
        user.setCity(userAccount.getCity());
        user.setCountry(userAccount.getCountry());
        user.setRole(roleService.findById(userAccount.getRole()));
        return userAccountRepository.save(user);
    }

    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();

    }

    public UserAccount update(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);

    }

    public UserAccount get(Long id) {
        return userAccountRepository.findById(id).get();

    }


}












