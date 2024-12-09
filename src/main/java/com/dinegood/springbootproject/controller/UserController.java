package com.dinegood.springbootproject.controller;

import com.dinegood.springbootproject.mapper.UserMapper;
import com.dinegood.springbootproject.model.Itemdetails;
import com.dinegood.springbootproject.model.UserDetails;
import com.dinegood.springbootproject.services.UserService;
import com.dinegood.springbootproject.validator.UserValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @PostMapping("/add/user")
    public ResponseEntity<UserDetails> createUser(@Valid @RequestBody final UserValidator userValidator) {
        UserDetails user = userMapper.toUserDetails(userValidator);
        UserDetails savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
    //********************Changed this as an enhancement****************************
//    private UserDetails mapToEntity(final UserValidator userValidator) {
//        UserDetails user = new UserDetails();
//        user.setUserName(userValidator.getUserName());
//        user.setMobileNo(userValidator.getMobileNo());
//        user.setEmail(userValidator.getEmail());
//        return user;
//    }
}
