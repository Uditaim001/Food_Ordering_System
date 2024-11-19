package com.dinegood.springbootproject.model;

import com.dinegood.springbootproject.entitylistener.UserEntityListener;
import jakarta.persistence.*;

@Entity
@Table(name = "user")
@EntityListeners(UserEntityListener.class)
public class UserDetails {
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "mobile_no")
    private String  mobileNo;
    @Column(name = "email")
    private String email;
}
