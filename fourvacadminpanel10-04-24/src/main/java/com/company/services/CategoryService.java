package com.company.services;

import com.company.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category addCategory(Category category);
    Category getCategoryById(Long id);
    Category getCategoryByName(String categoryName); // New method to get category by name
}
