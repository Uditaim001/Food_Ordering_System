package com.dinegood.springbootproject.controller;

import com.dinegood.springbootproject.model.CartDetails;
import com.dinegood.springbootproject.services.CartService;
import com.dinegood.springbootproject.model.Itemdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @PostMapping("/add/{userId}/{itemId}")
    public ResponseEntity<String> addItemToCart(@PathVariable int itemId,@PathVariable int userId) {
        Itemdetails item = cartService.addItemToCart(itemId,userId);
        if (item != null) {
            return ResponseEntity.ok("Item added to cart successfully!");
        } else {
            return ResponseEntity.status(404).body("Item not found.");
        }
    }
    @DeleteMapping("/remove/{userId}/{itemId}")
    public ResponseEntity<String> removeItemFromCart(@PathVariable int itemId, @PathVariable int userId) {
        boolean removed = cartService.removeItemFromCart(itemId,userId);
        if (removed) {
            return ResponseEntity.ok("Item removed from cart successfully.");
        } else {
            return ResponseEntity.status(404).body("Item not found in cart.");
        }
    }
//    @PostMapping("/add/items")
//    public ResponseEntity<CartDetails> createItem(@RequestBody final CartDetails cartDetails) {
//        CartDetails savedItem = cartService.createCart(cartDetails);
//        return ResponseEntity.ok(savedItem);
//    }

    @GetMapping("/details/{userId}")
    public Optional<CartDetails> getCartDetails(@PathVariable int userId) {
        Optional<CartDetails> cart = cartService.getCartDetails(userId);
        return ResponseEntity.ok(cart).getBody();
    }
}
