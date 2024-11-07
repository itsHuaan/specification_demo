package org.example.specification_demo.services;

import org.example.specification_demo.dtos.UserDto;
import org.example.specification_demo.entities.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService extends IBaseService<UserDto, UserEntity, Long> {
    List<UserDto> findUsersByFirstName(String firstName, Pageable pageable);
//    List<UserDto> findAll(Pageable pageable);

    Page<UserDto> findAll(Pageable pageable);
}
