package com.dinegood.springbootproject.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="category")
public class Categorydetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Category_id")
    private int id;


    @Column(name = "Category_rating")
    private int rating;

    @Column(name= "Category_name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


}
