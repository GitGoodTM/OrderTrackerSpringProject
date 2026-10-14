package com.sooraj.learning.ordertrackerspringproject.service;

import com.sooraj.learning.ordertrackerspringproject.dto.CategoryResponse;
import com.sooraj.learning.ordertrackerspringproject.dto.CreateCategoryRequest;
import com.sooraj.learning.ordertrackerspringproject.entity.Category;
import com.sooraj.learning.ordertrackerspringproject.exception.CategoryNotFoundException;
import com.sooraj.learning.ordertrackerspringproject.exception.DuplicateCategoryException;
import com.sooraj.learning.ordertrackerspringproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryResponse create(CreateCategoryRequest request) {
        if (categoryRepository.existsByCategoryName(request.getCategoryName())){
            throw new DuplicateCategoryException(request.getCategoryName());
        }
        Category saved = categoryRepository.save(new Category(request.getCategoryName()));
        return toResponse(saved);
    }

    @Override
    public List<CategoryResponse> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream()
                .map(this::toResponse).toList();
    }

    @Override
    public CategoryResponse findById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));
        return toResponse(category);
    }

    private CategoryResponse toResponse(Category category){
        return new CategoryResponse(category.getCategoryId(), category.getCategoryName());
    }
}
