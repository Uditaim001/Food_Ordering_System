package com.dinegood.springbootproject.entitylistener;

import com.dinegood.springbootproject.component.AESUtil;
import com.dinegood.springbootproject.model.UserDetails;
import jakarta.persistence.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserEntityListener {

    private static AESUtil aesUtil;

    @Autowired
    public void injectDependency(final AESUtil aesUtil) {
        UserEntityListener.aesUtil = aesUtil;
    }

    @PreUpdate
    @PrePersist
    public void saveUser(final UserDetails user) throws Exception {

        user.setUserName(aesUtil.encrypt(user.getUserName()));
        user.setMobileNo(aesUtil.encrypt(user.getMobileNo()));
        user.setEmail(aesUtil.encrypt(user.getEmail()));

    }

    @PostLoad
    @PostPersist
    @PostUpdate
    public void getUserById(final UserDetails user) throws Exception {
        user.setUserName(aesUtil.decrypt(user.getUserName()));
        user.setMobileNo(aesUtil.decrypt(user.getMobileNo()));
        user.setEmail(aesUtil.decrypt(user.getEmail()));
    }
}
