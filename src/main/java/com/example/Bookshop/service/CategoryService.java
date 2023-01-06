package com.example.Bookshop.service;

import com.example.Bookshop.models.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();
    Category getCategoryByCode(Long code);
    Category saveCategory(Category category);
    void deleteCategoryByCode(Long code);
    void deleteAll();
}
