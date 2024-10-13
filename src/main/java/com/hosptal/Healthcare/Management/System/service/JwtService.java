package com.hosptal.Healthcare.Management.System.service;

import org.springframework.security.core.userdetails.UserDetails;

public class JwtService {

    private final String SECRET_KEY;

    private JwtService() {
        SECRET_KEY = generateSecreteKey();
    }

    private String generateSecreteKey() {
    }

    public String extractUserName(String token) {
        return "";
    }

    public boolean validateToken(String username, UserDetails userDetails) {
        return true;
    }

    public String generateToken(String username) {
        return "";
    }
}
