package com.dinegood.springbootproject.repo;

import com.dinegood.springbootproject.model.CartDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepo extends CrudRepository<CartDetails,Integer> {
    Optional<CartDetails> findByUserId(int userId);

}
