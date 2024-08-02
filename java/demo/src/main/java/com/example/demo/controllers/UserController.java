//package com.example.demo.controllers;
//import com.example.demo.entities.User;
//import com.example.demo.repository.UserDetailsRepository;
//import com.example.demo.services.CustomUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//
//@RestController
//@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:3000")
//public class UserController {
//
//    @Autowired
//    private UserDetailsRepository userDetailsRepository;
//
//    @Autowired
//    private CustomUserService customUserService;
//
//    @GetMapping("/test")
//    public String test() {
//        return "test!";
//    }
//
//    @GetMapping("/users")
//    public List<User> getAllUsers() {
//        return userDetailsRepository.findAll();
//    }
//
////    @GetMapping("/users/{id}")
////    public Optional<User> getUserById(@PathVariable Long id) {
////        System.out.println("id :" + id);
////        return userDetailsRepository.findById(id);
////    }
////    @GetMapping("/users/{id}")
////    public Optional<User> getUserById(@PathVariable Long id) {
////        System.out.println("Fetching user with id: " + id);
////        Optional<User> user = userDetailsRepository.findById(id);
////        System.out.println("User fetched: " + user);
////        return user;
////    }
//    @GetMapping("/user")
//    public Optional<User> getUserById(@PathVariable Long id) {
//        System.out.println("Fetching user with id: " + id);
//        Optional<User> user = userDetailsRepository.findById(id);
//        System.out.println("User fetched: " + user);
//        return user;
//    }
//
//
//}
////    @PostMapping("/get_users")
////    public Optional<User> getUser(@RequestBody Long id){
////        return userDetailsRepository.findById(id);
////    }
//

package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<User> getUserByIdPathVariable(@PathVariable Long id) {
        System.out.println("Fetching user with id: " + id);
        Optional<User> user = userDetailsRepository.findById(id);
        if (user.isPresent()) {
            System.out.println("User found: " + user.get());
        } else {
            System.out.println("User not found with id: " + id);
        }
        return user;
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
}


