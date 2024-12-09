package com.dinegood.springbootproject.repo;

import com.dinegood.springbootproject.model.Categorydetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repo extends CrudRepository<Categorydetails, Integer>{
    public Categorydetails findById(int id);
}
