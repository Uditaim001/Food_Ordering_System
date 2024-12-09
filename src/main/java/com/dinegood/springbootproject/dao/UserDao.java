package com.dinegood.springbootproject.dao;

import com.dinegood.springbootproject.model.UserDetails;
import com.dinegood.springbootproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDao {
    @Autowired
    private UserRepo userRepo;
    public UserDetails getEncryptedUser(int userId) {

        return userRepo.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
    public UserDetails saveUser(final UserDetails user){
        return userRepo.save(user);
    }
}
