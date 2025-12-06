package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.dto.UserAccountDto;
import com.projekt.Online_Shop.entities.GenericEntity;
import com.projekt.Online_Shop.entities.UserAccount;
import com.projekt.Online_Shop.repositories.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    public UserAccount update(UserAccountDto userAccountDto) {
        //per tu zgjidhur
        UserAccount existing = userAccountRepository.findById(userAccountDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
                existing.setEmail(userAccountDto.getEmail());
                existing.setPassword(passwordEncoder.encode(userAccountDto.getPassword()));
                existing.setCity(userAccountDto.getCity());
                existing.setCountry(userAccountDto.getCountry());
                existing.setRole(roleService.findById(userAccountDto.getRole()));
                return userAccountRepository.save(existing);
    }

    public UserAccount findById(Long id) {
        return userAccountRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserAccount findLoggedIn() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.findByEmail(username);
    }

    public UserAccount findByEmail(String email) {
        return userAccountRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    //find logged in user
    public UserAccount findLoggedUser() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.findByEmail(username);
    }

}












