package com.thiagoporfirio.elvivo.security.auth;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements IAuth
{
    private final PasswordEncoder passwordEncoder;

    public String encodePassword(String rawPassword)
    {
        return this.passwordEncoder.encode(rawPassword);
    }
}
