package com.dinegood.springbootproject.validator;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserValidator {
    @NotBlank(message = "user name required")
    @Pattern(regexp = "^[a-zA-Z0-9_ ]*$", message = "Username must be alphanumeric and include spaces,and 2-15 characters long")
    private String userName;
    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^\\+91[0-9]{10}$", message = "Invalid mobile number format")
    private String mobileNo;
    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
            flags = Pattern.Flag.CASE_INSENSITIVE)
    private String email;

//    public @NotBlank(message = "user name required") @Pattern(regexp = "^[a-zA-Z0-9]{2,15}$", message = "Username must be alphanumeric and 2-15 characters long") String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(@NotBlank(message = "user name required") @Pattern(regexp = "^[a-zA-Z0-9_][a-zA-Z0-9_ ]*[a-zA-Z0-9_]$", message = "Username must be alphanumeric and 2-15 characters long") String userName) {
//        this.userName = userName;
//    }
//
//    public @NotBlank(message = "Mobile number is required") @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid mobile number format") String getMobileNo() {
//        return mobileNo;
//    }
//
//    public void setMobileNo(@NotBlank(message = "Mobile number is required") @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid mobile number format") String mobileNo) {
//        this.mobileNo = mobileNo;
//    }
//
//    public @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
//            flags = Pattern.Flag.CASE_INSENSITIVE) String getEmail() {
//        return email;
//    }
//
//    public void setEmail(@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
//            flags = Pattern.Flag.CASE_INSENSITIVE) String email) {
//        this.email = email;
//    }
}
