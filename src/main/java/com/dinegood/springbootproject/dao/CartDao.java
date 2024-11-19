package com.dinegood.springbootproject.dao;

import com.dinegood.springbootproject.model.CartDetails;
import com.dinegood.springbootproject.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class CartDao {
    @Autowired
    private CartRepo cartRepo;
    public CartDetails addItemtoCarts(final int itemcost, final int userId) {
        CartDetails cart = new CartDetails();
        cart.setUserId(userId);
        cart.setAmount(itemcost);
        cart.setDate(LocalDate.from(LocalDateTime.now()));
        return cart;}

    public Optional<CartDetails> findbyuser(final int userId){
        return cartRepo.findByUserId(userId);


}
    public Optional<CartDetails> findByUserId(int userId){
        return cartRepo.findByUserId(userId);
    }
    public void saveCart(final CartDetails cart){
        cartRepo.save(cart);
    }


}




