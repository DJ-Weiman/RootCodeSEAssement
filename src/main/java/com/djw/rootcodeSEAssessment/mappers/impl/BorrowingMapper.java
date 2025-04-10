package com.djw.rootcodeSEAssessment.mappers.impl;

import com.djw.rootcodeSEAssessment.domain.dto.BorrowingDto;
import com.djw.rootcodeSEAssessment.domain.entities.BorrowingEntity;
import com.djw.rootcodeSEAssessment.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BorrowingMapper implements Mapper<BorrowingEntity, BorrowingDto> {

    private final ModelMapper modelMapper;

    public BorrowingMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public BorrowingDto mapTo(BorrowingEntity borrowingEntity) {
        return modelMapper.map(borrowingEntity, BorrowingDto.class);
    }

    @Override
    public BorrowingEntity mapFrom(BorrowingDto borrowingDto) {
        return modelMapper.map(borrowingDto, BorrowingEntity.class);
    }
}
