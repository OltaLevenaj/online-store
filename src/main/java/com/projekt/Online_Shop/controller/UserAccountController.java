package com.projekt.Online_Shop.controller;

import com.projekt.Online_Shop.dto.UserAccountDto;
import com.projekt.Online_Shop.entities.UserAccount;
import com.projekt.Online_Shop.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @PostMapping
    public UserAccount create(@RequestBody UserAccountDto dto) {
        return userAccountService.create(dto);
    }

    @GetMapping
    public List<UserAccount> findAll() {
        return userAccountService.findAll();
    }

    @GetMapping("/{id}")
    public UserAccount findById(@PathVariable Long id) {
        return userAccountService.findById(id);
    }

    @PutMapping
    public UserAccount update(@RequestBody UserAccountDto dto) {
        return userAccountService.update(dto);
    }

}
