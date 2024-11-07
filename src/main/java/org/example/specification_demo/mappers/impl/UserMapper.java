package org.example.specification_demo.mappers.impl;

import org.example.specification_demo.dtos.UserDto;
import org.example.specification_demo.entities.UserEntity;
import org.example.specification_demo.mappers.BaseMapper;
import org.example.specification_demo.models.UserModel;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements BaseMapper<UserDto, UserEntity, UserModel> {
    @Override
    public UserDto toDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .age(userEntity.getAge())
                .email(userEntity.getEmail())
                .build();
    }

    @Override
    public UserEntity toEntity(UserModel userModel) {
        return UserEntity.builder()
                .id(userModel.getId())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .age(userModel.getAge())
                .email(userModel.getEmail())
                .build();
    }
}
