package com.djw.rootcodeSEAssessment.services;

import com.djw.rootcodeSEAssessment.domain.dto.UserDto;
import com.djw.rootcodeSEAssessment.domain.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);

    List<UserDto> getAllUsers();

}
