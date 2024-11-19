package com.dinegood.springbootproject.services;

import com.dinegood.springbootproject.dao.Cartdao;
import com.dinegood.springbootproject.dao.Itemdao;
import com.dinegood.springbootproject.model.CartDetails;
import com.dinegood.springbootproject.model.Itemdetails;
import com.dinegood.springbootproject.repo.CartRepo;
import com.dinegood.springbootproject.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private Cartdao cartdao;
    @Autowired
    private Itemdao itemdao;

    public Itemdetails addItemToCart(final int itemId, final int userId) {
        Optional<Itemdetails> itemOpt = itemdao.findByCategs(itemId);
        if (itemOpt.isEmpty()) {
            return null;
        }
        //TODO--Put Optional here
        Itemdetails item = itemOpt.get();

        Optional<CartDetails> cart=cartdao.findbyuser(userId);

        if (cart.isPresent()) {
            cart.get().setAmount(cart.get().getAmount() + item.getCost());
        } else {
            cart= Optional.ofNullable(cartdao.addItemtoCarts(item.getCost(), userId));
        }
        cartdao.saveCart(cart.get());

        return item;
    }

    public boolean removeItemFromCart(final int itemId, final int userId) {
        Optional<CartDetails> cart = cartdao.findByUserId(userId);
        if (cart == null) {
            return false;
        }

        Optional<Itemdetails> itemOpt = itemRepo.findById(itemId);
        if (!itemOpt.isPresent()) {
            return false;
        }
        Itemdetails item = itemOpt.get();

        cart.get().setAmount(cart.get().getAmount() - item.getCost());

        cartdao.saveCart(cart.get());

        return true;
    }

//    public CartDetails createCart(final CartDetails cartDetails) {
//        return cartRepo.save(cartDetails);
//    }

    public Optional<CartDetails> getCartDetails(final int userId) {
        return cartdao.findByUserId(userId);
    }

//    public List<Itemdetails> getCartItems(final int userId) {
//        CartDetails cart = cartRepo.findByUserId(userId);
//        if (cart == null) {
//            return null;
//        }
//
//        return cart.getCartItems();
//    }
}
