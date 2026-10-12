package com.sooraj.learning.ordertrackerspringproject.dto;

public class CategoryResponse {
    private Long categoryId;

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    private String categoryName;

    public CategoryResponse(Long categoryId, String categoryName){
        this.categoryId=categoryId;
        this.categoryName=categoryName;
    }
}
