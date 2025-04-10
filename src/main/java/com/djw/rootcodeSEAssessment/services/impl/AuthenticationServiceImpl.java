package com.djw.rootcodeSEAssessment.services.impl;

import com.djw.rootcodeSEAssessment.services.AuthenticationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public UserDetails authenticate(String userName, String password) {
        return null;
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return "";
    }

    //    private final AuthenticationManager authenticationManager;
//    private final UserDetailsService userDetailsService;
//
//    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, UserDetailsService userDetailsService) {
//        this.authenticationManager = authenticationManager;
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Value("${jwt.secret}")
//    private String secretKey;
//
//    private final Long jwtExpiryMs = 86400000L;
//
//    @Override
//    public UserDetails authenticate(String userName, String password) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(userName, password)
//        );
//        return userDetailsService.loadUserByUsername(userName);
//    }
//
//    @Override
//    public String generateToken(UserDetails userDetails) {
//        Map<String, Object> claims = new HashMap<>();
//        return "";
//    }

//    private Key getSigningKey() {
//        byte[] keyBytes = secretKey.getBytes();
//        return Keys.hmacShaKeyFor(keyBytes);
//    }

}
