package com.dinegood.springbootproject.mapper;

import com.dinegood.springbootproject.model.UserDetails;
import com.dinegood.springbootproject.validator.UserValidator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "userName", target = "userName")
    @Mapping(source = "mobileNo", target = "mobileNo")
    @Mapping(source = "email", target = "email")
    UserDetails toUserDetails(UserValidator userValidator);

}

