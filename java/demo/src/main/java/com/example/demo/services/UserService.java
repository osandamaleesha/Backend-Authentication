package com.example.demo.services;

import com.example.demo.dto.AuthenticationDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.exeption.OctopusDAOException;
import org.springframework.cache.annotation.CacheEvict;

import java.util.Optional;

public interface UserService {


    @CacheEvict(value = "users", allEntries = true) // Clear cache on save
    void saveUser(UserDTO userDTO) throws OctopusDAOException;

    @CacheEvict(value = "users", allEntries = true) // Clear cache on save
    void saveUser(UserDTO userDTO, AuthenticationDTO authDTO) throws OctopusDAOException;

    Optional<UserDTO> getUserById(Long id);
    boolean isEmailAlreadyUsed(String email);

    Object loadUserByUsername(String name);
}
