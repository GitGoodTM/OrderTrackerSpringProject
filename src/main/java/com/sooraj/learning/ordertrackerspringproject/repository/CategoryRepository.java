package com.sooraj.learning.ordertrackerspringproject.repository;

import com.sooraj.learning.ordertrackerspringproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByCategoryName(String name);
}
