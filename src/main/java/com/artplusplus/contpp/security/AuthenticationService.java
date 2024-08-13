package com.artplusplus.contpp.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;

import jakarta.servlet.http.HttpServletRequest;

import io.github.cdimascio.dotenv.Dotenv;

public class AuthenticationService {
    static Dotenv dotenv = Dotenv.configure().load();

    public static Authentication getAuthentication(HttpServletRequest request) {
        String apiKey = request.getHeader(dotenv.get("APP_AUTH_TOKEN_KEY"));
        if (apiKey == null || !apiKey.equals((dotenv.get("APP_AUTH_TOKEN")))) {
            throw new BadCredentialsException("Invalid API Key");
        }

        return new ApiKeyAuthentication(apiKey, AuthorityUtils.NO_AUTHORITIES);
    }
}