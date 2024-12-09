package com.dinegood.springbootproject.controller;

import com.dinegood.springbootproject.services.CategoryService;
import com.dinegood.springbootproject.model.Categorydetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService catservice;
    @GetMapping("/category")
    public List<Categorydetails> getallcategory(){
        return this.catservice.getAllcat();
    }

}
