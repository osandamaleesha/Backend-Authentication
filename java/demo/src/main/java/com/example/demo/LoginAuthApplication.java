package com.example.demo;

import com.example.demo.entities.Authority;
import com.example.demo.entities.User;
import com.example.demo.repository.UserDetailsRepository;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;



@SpringBootApplication
@EnableCaching
public class LoginAuthApplication {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsRepository userDetailsRepository;


    public static void main(String[] args) {
        SpringApplication.run(LoginAuthApplication.class, args);
        System.out.print("init");
    }

    @PostConstruct
    protected void init() {

        List<Authority> authorityList = new ArrayList<>();

        authorityList.add(createAuthority("ADMIN", "Admin role"));
        authorityList.add(createAuthority("DOCTOR", "Doctor role"));

        User user = new User();

        user.setUserName("Ushan1");
        user.setFirstName("Ushan1");
        user.setLastName("Gallage");

        user.setPassword(passwordEncoder.encode("123"));
        user.setEnabled(true);
        user.setAuthorities(authorityList);

//        userDetailsRepository.save(user);

    }

     private Authority createAuthority(String roleCode,String roleDescription) {
     Authority authority=new Authority();
     authority.setRoleCode(roleCode);
     authority.setRoleDescription(roleDescription);
     return authority;

  }


}