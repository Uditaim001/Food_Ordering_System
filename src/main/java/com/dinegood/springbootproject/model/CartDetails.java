package com.dinegood.springbootproject.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "cart")
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private int cartId;

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Column(name="user_id")
    private int userId;
    @Column(name="Total_Amount")
    private int amount;
    @Column(name = "date")
    private LocalDate date;
}
