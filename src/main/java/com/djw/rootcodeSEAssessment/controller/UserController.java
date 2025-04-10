package com.djw.rootcodeSEAssessment.controller;

import com.djw.rootcodeSEAssessment.domain.dto.UserDto;
import com.djw.rootcodeSEAssessment.domain.entities.UserEntity;
import com.djw.rootcodeSEAssessment.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/library/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto user){
        UserDto savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> savedUsers = userService.getAllUsers();
        return new ResponseEntity<>(savedUsers, HttpStatus.OK);
    }

}
