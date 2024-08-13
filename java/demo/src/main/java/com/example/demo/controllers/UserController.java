
package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repository.UserDetailsRepository;
import com.example.demo.responses.UserFoundResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @GetMapping("/test")
    public String test() {
        return "test!";
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userDetailsRepository.findAll();
        System.out.println("All users: " + users);
        return users;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserFoundResponse> getUserByIdPathVariable(@PathVariable Long id) {
        System.out.println("Fetching user with id: " + id);
        Optional<User> user = userDetailsRepository.findById(id);
        if (user.isPresent()) {
            UserFoundResponse userFoundResponse = new UserFoundResponse("User found", List.of(user.get()));
            return ResponseEntity.ok(userFoundResponse);
        } else {
            UserFoundResponse userNotFoundResponse = new UserFoundResponse("User not found", List.of());
            return ResponseEntity.status(404).body(userNotFoundResponse);
        }
    }

    @GetMapping("/user")
    public Optional<User> getUserByIdQueryParam(@RequestParam Long id) {
        System.out.println("Fetching user with id: " + id);
        Optional<User> user = userDetailsRepository.findById(id);
        if (user.isPresent()) {
            System.out.println("User found: " + user.get());
        } else {
            System.out.println("User not found with id: " + id);
        }
        return user;
    }

    @PostMapping("/addUsers")
    public ResponseEntity<UserFoundResponse> addUser(@RequestBody User newUser) {
        User savedUser = userDetailsRepository.save(newUser);
        UserFoundResponse userFoundResponse = new UserFoundResponse("User added successfully", List.of(savedUser));
        return ResponseEntity.status(201).body(userFoundResponse);
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserFoundResponse> deleteUser(@PathVariable Long id) {

        Optional<User> user = userDetailsRepository.findById(id);
        if (user.isPresent()) {
            userDetailsRepository.deleteById(id);
            UserFoundResponse userDeletedResponse = new UserFoundResponse("User deleted successfully", List.of(user.get()));
            return ResponseEntity.ok(userDeletedResponse);
        } else {
            UserFoundResponse userNotFoundResponse = new UserFoundResponse("User not found", List.of());
            return ResponseEntity.status(404).body(userNotFoundResponse);
        }
    }
}
