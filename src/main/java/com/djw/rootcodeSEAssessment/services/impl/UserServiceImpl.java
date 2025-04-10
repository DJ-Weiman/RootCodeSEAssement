package com.djw.rootcodeSEAssessment.services.impl;

import com.djw.rootcodeSEAssessment.domain.dto.UserDto;
import com.djw.rootcodeSEAssessment.domain.entities.UserEntity;
import com.djw.rootcodeSEAssessment.mappers.Mapper;
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
    private final Mapper<UserEntity, UserDto> userMapper;

    public UserServiceImpl(UserRepository userRepository, Mapper<UserEntity, UserDto> userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        userDto.setCreated_at(LocalDateTime.now());
        UserEntity savedUser = userRepository.save(userMapper.mapFrom(userDto));

        return userMapper.mapTo(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .map(userMapper::mapTo)
                .collect(Collectors.toList());
    }
}
