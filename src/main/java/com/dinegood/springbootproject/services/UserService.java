package com.dinegood.springbootproject.services;

import com.dinegood.springbootproject.component.AESUtil;
import com.dinegood.springbootproject.dao.UserDao;
import com.dinegood.springbootproject.model.UserDetails;
import com.dinegood.springbootproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private UserDao userdao;
    @Autowired
    private AESUtil aesUtil;
    public UserDetails saveUser(final UserDetails user) {
        return userdao.saveUser(user);
    }

    public UserDetails getEncryptedUser(int userId) {

            return   userdao.getEncryptedUser(userId);  }
}
