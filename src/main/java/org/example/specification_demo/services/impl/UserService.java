package org.example.specification_demo.services.impl;

import org.example.specification_demo.dtos.UserDto;
import org.example.specification_demo.entities.UserEntity;
import org.example.specification_demo.mappers.impl.UserMapper;
import org.example.specification_demo.repositories.IUserRepository;
import org.example.specification_demo.services.IUserService;
import org.example.specification_demo.utils.UserSpecification;
import org.springdoc.core.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserService(IUserRepository userRepository, UserMapper userMapper, SecurityService securityParser) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }

    @Override
    public UserDto save(UserEntity entity) {
        return null;
    }

    @Override
    public int delete(Long id) {
        return 0;
    }


    @Override
    public List<UserDto> findUsersByFirstName(String firstName, Pageable pageable) {
        Specification<UserEntity> spec = Specification.where(UserSpecification.firstName(firstName));
        return pageable != null
                ? userRepository.findAll(spec, pageable).stream().map(userMapper::toDto).collect(Collectors.toList())
                : userRepository.findAll(spec).stream().map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Page<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toDto);
    }
}
