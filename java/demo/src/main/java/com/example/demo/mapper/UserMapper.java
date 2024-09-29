package com.example.demo.mapper;

import com.example.demo.dto.AuthenticationDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

//    private final PasswordEncoder passwordEncoder;
//
//    public UserMapper(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }

    // Convert UserDTO and AuthenticationDTO to User Entity
    public User toEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }
        User user = new User();
        user.setUserName(userDTO.getUserName());
        user.setEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());

        // Use password from AuthenticationDTO and encode it
       // user.setPassword(passwordEncoder.encode(authDTO.getPassword()));

        // Set authorities from UserDTO if needed
        // user.setAuthorities(userDTO.getAuthorities());

        return user;
    }

    // Convert User Entity to UserDTO
    public UserDTO toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        return userDTO;
    }
}
