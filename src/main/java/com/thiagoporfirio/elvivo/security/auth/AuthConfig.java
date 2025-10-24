package com.thiagoporfirio.elvivo.security.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashMap;

@Configuration
public class AuthConfig
{
    @Bean
    public PasswordEncoder passwordEncoder()
    {
        var encoders = new HashMap<String, PasswordEncoder>();

        encoders.put("bcrypt", new BCryptPasswordEncoder());

        //DelegatingPasswordEncoder

        return new DelegatingPasswordEncoder("bcrypt", encoders);
    }
}
