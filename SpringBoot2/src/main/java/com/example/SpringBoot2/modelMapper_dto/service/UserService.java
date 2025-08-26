package com.example.SpringBoot2.modelMapper_dto.service;


import com.example.SpringBoot2.modelMapper_dto.dto.UserDTO;
import com.example.SpringBoot2.modelMapper_dto.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ModelMapper modelMapper;

    public UserService(ModelMapper modelMapper) { //Constructor Injection
        this.modelMapper = modelMapper;
    }

    public UserDTO convertToDTO(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDTO.class);
    }

    public UserEntity convertToEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
}