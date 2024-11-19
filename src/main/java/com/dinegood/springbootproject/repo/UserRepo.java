package com.dinegood.springbootproject.repo;

import com.dinegood.springbootproject.model.UserDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserDetails,Integer> {
}
