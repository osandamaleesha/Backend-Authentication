package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.exeption.OctopusDAOException;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) throws OctopusDAOException {
        userService.saveUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws OctopusDAOException {
        Optional<UserDTO> userDTO = userService.getUserById(id);
        if (userDTO != null) {
            throw new OctopusDAOException("User not found with id: " + id);
        }
        return ResponseEntity.ok(userDTO.get());
    }
}
