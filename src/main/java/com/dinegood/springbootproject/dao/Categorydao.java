package com.dinegood.springbootproject.dao;

import com.dinegood.springbootproject.model.Categorydetails;
import com.dinegood.springbootproject.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class Categorydao {
    @Autowired
    private Repo repo;
    public List<Categorydetails> getcatgs(){
        try{List<Categorydetails> category= (List<Categorydetails>) this.repo.findAll();
        return category;}
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public Categorydetails getCatgsById(final int id){
        Categorydetails category=null;
        try {
            category=this.repo.findById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
}
