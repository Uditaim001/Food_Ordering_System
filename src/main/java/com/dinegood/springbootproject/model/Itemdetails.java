package com.dinegood.springbootproject.model;

import jakarta.persistence.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.lang.annotation.Documented;

@Entity
@Table(name="items")
public class Itemdetails {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="Item_name")
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Integer)
    @Column(name="Item_cost")
    private int cost;
    @Field(type = FieldType.Integer)
    @Column(name="Cat_Id")
    private int category;
    @Field(type = FieldType.Integer)
    @Column(name="rating")
    private int rating;
    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(final int cost) {
        this.cost = cost;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(final int category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(final int rating) {
        this.rating = rating;
    }

}
