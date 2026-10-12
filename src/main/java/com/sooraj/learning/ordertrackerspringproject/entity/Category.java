package com.sooraj.learning.ordertrackerspringproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categories")
public class Category {
    protected Category(){}
    public Category(String name){
        this.categoryName=name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(nullable = false, unique = true, length = 100)
    private String categoryName;
}
