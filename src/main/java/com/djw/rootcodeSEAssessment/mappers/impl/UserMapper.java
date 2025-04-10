package com.djw.rootcodeSEAssessment.mappers.impl;

import com.djw.rootcodeSEAssessment.domain.dto.UserDto;
import com.djw.rootcodeSEAssessment.domain.entities.UserEntity;
import com.djw.rootcodeSEAssessment.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserEntity, UserDto> {

    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto mapTo(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserEntity mapFrom(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}
