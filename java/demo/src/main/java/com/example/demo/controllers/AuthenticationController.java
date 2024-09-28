package com.example.demo.controllers;

import com.example.demo.config.JWTTokenHelper;
import com.example.demo.dto.AuthenticationDTO;
import com.example.demo.dto.LoginDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.Authority;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.spec.InvalidKeySpecException;
import java.util.Collection;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JWTTokenHelper jwtTokenHelper;

    ;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO authenticationRequest) throws InvalidKeySpecException, NoSuchAlgorithmException {

        // Authenticate user
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUserName(),
                        authenticationRequest.getPassword()
                )
        );

        // Set authentication in security context
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Generate JWT token
        User user = (User) authentication.getPrincipal();
        String jwtToken = jwtTokenHelper.generateToken(user.getUsername());

        // Create and return the response
        LoginDTO response = new LoginDTO();
        response.setToken(jwtToken);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/auth/userinfo")
    public ResponseEntity<?> getUserInfo(Principal user) {
        // Fetch user details using the Principal
        User userObj = (User) userService.loadUserByUsername(user.getName());

        // Create and return user info response
        UserDTO userInfoDto = new UserDTO();
        userInfoDto.setFirstName(userObj.getFirstName());
        userInfoDto.setLastName(userObj.getLastName());

        // Convert GrantedAuthority to SimpleGrantedAuthority
        Collection<SimpleGrantedAuthority> simpleGrantedAuthorities = userObj.getAuthorities().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .toList();

        userInfoDto.setAuthorities(simpleGrantedAuthorities);

        return ResponseEntity.ok(userInfoDto);
    }
}
