package com.djw.rootcodeSEAssessment.services.impl;

import com.djw.rootcodeSEAssessment.domain.entities.UserEntity;
import com.djw.rootcodeSEAssessment.repositories.UserRepository;
import com.djw.rootcodeSEAssessment.services.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserEntity createUser(UserEntity user) {
        user.setCreated_at(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
