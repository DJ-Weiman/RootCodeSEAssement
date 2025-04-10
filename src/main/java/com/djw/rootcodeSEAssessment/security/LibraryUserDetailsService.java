package com.djw.rootcodeSEAssessment.security;

import com.djw.rootcodeSEAssessment.domain.entities.UserEntity;
import com.djw.rootcodeSEAssessment.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class LibraryUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public LibraryUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByName(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with Username:" + username));

        return new LibraryUserDetails(userEntity);
    }

}
