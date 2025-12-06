package com.projekt.Online_Shop.controller;

import com.projekt.Online_Shop.dto.UserAccountDto;
import com.projekt.Online_Shop.entities.UserAccount;
import com.projekt.Online_Shop.services.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class UserAccountController {
    @Autowired
    private UserAccountService userAccountService;

    @PostMapping("/user/create")
    public UserAccount create(@RequestBody UserAccountDto dto) {
        return userAccountService.create(dto);
    }

    @GetMapping("/user/accounts")
    public List<UserAccount> findAll() {
        return userAccountService.findAll();
    }

    @GetMapping("/user/accounts/{id}")
    public UserAccount findById(@PathVariable Long id) {
        return userAccountService.findById(id);
    }

    @PutMapping("/user/update")
    public UserAccount update(@RequestBody UserAccountDto dto) {
        return userAccountService.update(dto);
    }

}
