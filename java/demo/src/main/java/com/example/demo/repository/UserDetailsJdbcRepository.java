package com.example.demo.repository;
//UserDetailsRepository

import com.example.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//link userRepository with UserDetailsService interface
@Repository
public interface UserDetailsJdbcRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);


}
