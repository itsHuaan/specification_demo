package org.example.specification_demo.controllers;

import org.example.specification_demo.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getUser(@RequestParam(required = false) String firstName,
                                     @RequestParam(required = false) int pageSize,
                                     @RequestParam(required = false) int pageIndex) {
        PageRequest pageable = PageRequest.of(pageIndex, pageSize);
        return firstName != null
                ? new ResponseEntity<>(userService.findUsersByFirstName(firstName, pageable), HttpStatus.OK)
                : new ResponseEntity<>(userService.findAll(pageable), HttpStatus.OK);
    }
}
