package com.dinegood.springbootproject;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
//@Component
////@Builder
//@Data
//@AllArgsConstructor
//@RequiredArgsConstructor
//@NoArgsConstructor
public class Testcontroller {
    @RequestMapping("/hotel")
    public ResponseEntity<String> firsthandler(){
        return new ResponseEntity<>("Welcome to Hawaii Hotel !!! What would you like to have:)", HttpStatus.OK);
    }
}
