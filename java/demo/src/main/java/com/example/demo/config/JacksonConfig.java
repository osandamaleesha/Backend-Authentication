package com.example.demo.config;

import com.example.demo.dto.UserDTO;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Configuration
public class JacksonConfig {

    @Bean
    public Module customJacksonModule() {
        SimpleModule module = new SimpleModule();
        // Add the mixin for SimpleGrantedAuthority
        module.setMixInAnnotation(SimpleGrantedAuthority.class, UserDTO.SimpleGrantedAuthorityMixin.class);
        return module;
    }
}
