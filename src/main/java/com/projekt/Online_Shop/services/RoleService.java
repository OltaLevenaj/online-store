package com.projekt.Online_Shop.services;

import com.projekt.Online_Shop.entities.Role;
import com.projekt.Online_Shop.repositories.RoleRepository;
import com.projekt.Online_Shop.static_data.Roles;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @PostConstruct
    public void init() {
        Arrays.stream(Roles.values()).forEach(role -> {
            if (!roleRepository.existsById(role.name())) {
                roleRepository.save(new Role(role.name()));
            }
        });
    }

    public Role findById(String id) {
        return roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not found"));
    }
}
