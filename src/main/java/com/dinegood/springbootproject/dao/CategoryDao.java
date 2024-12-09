package com.dinegood.springbootproject.dao;

import com.dinegood.springbootproject.model.Categorydetails;
import com.dinegood.springbootproject.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CategoryDao {
    @Autowired
    private Repo repo;
    public List<Categorydetails> getcatgs() {
        try {
            return (List<Categorydetails>) repo.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Error fetching categories", e);
        }
    }

    public Categorydetails getCatgsById(final int id) {
        try {
            Categorydetails category = this.repo.findById(id);
            if (category == null) {
                throw new RuntimeException("Category not found with id: " + id);
            }
            return category;

        } catch (Exception e) {
            throw new RuntimeException("Error fetching category by ID: " + id, e);
        }
    }
}
