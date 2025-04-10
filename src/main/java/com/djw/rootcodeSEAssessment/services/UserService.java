package com.djw.rootcodeSEAssessment.services;

import com.djw.rootcodeSEAssessment.domain.entities.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity user);

    List<UserEntity> getAllUsers();

}
