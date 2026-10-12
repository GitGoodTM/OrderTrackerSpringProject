package com.sooraj.learning.ordertrackerspringproject.service;

import com.sooraj.learning.ordertrackerspringproject.dto.CategoryResponse;
import com.sooraj.learning.ordertrackerspringproject.dto.CreateCategoryRequest;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CreateCategoryRequest request);
    List<CategoryResponse> findAll();
    CategoryResponse findById(Long id);
}
