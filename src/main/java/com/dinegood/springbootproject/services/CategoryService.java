package com.dinegood.springbootproject.services;

import com.dinegood.springbootproject.dao.CategoryDao;
import com.dinegood.springbootproject.repo.Repo;
import com.dinegood.springbootproject.model.Categorydetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService {
     @Autowired
     private Repo repo;
     @Autowired
     private CategoryDao categorydao;
     public List<Categorydetails> getAllcat(){
         return categorydao.getcatgs();
     }
     public Categorydetails getCategoryById(final int id){
         return categorydao.getCatgsById(id);
    }


}
