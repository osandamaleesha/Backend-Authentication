package com.example.demo.services;

import com.example.demo.dto.AuthenticationDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.exeption.OctopusDAOException;
import com.example.demo.repository.UserDetailsRepository;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDetailsRepository userDetailsRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userDetailsRepository.findByUserName(userName);
    }

    @Override
    public boolean isEmailAlreadyUsed(String email) {
        return userDetailsRepository.existsByEmail(email);
    }

    @Override
    public void saveUser(UserDTO userDTO) throws OctopusDAOException {

    }

    @Override
    @CacheEvict(value = "users", allEntries = true) // Clear cache on save
    public void saveUser(UserDTO userDTO, AuthenticationDTO authDTO) throws OctopusDAOException {
        if (isEmailAlreadyUsed(userDTO.getEmail())) {
            throw OctopusDAOException.customerAlreadyExists();
        }

        // Pass both UserDTO and AuthenticationDTO to toEntity
        User newUser = userMapper.toEntity(userDTO);
        userDetailsRepository.save(newUser);
    }

    @Override
    @Cacheable(value = "users", key = "#id") // Cache result of this method
    public Optional<UserDTO> getUserById(Long id) {
        Optional<User> userOptional = userDetailsRepository.findById(id);
        return userOptional.map(userMapper::toDto);
    }
}
