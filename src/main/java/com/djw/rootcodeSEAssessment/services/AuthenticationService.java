package com.djw.rootcodeSEAssessment.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface AuthenticationService {
    UserDetails authenticate(String userName, String password);
    String generateToken(UserDetails userDetails);
}
