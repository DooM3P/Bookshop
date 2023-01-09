package com.example.Bookshop.service;

import com.example.Bookshop.DAO.CategoryDAO;
import com.example.Bookshop.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;
    @Override
    public List<Category> getCategories() {
        List<Category> categories = (List<Category>) categoryDAO.findAll();
        if(!categories.isEmpty()){
            return categories;
        }else {
            return null;
        }
    }


    @Override
    public Category getCategoryByCode(Long code) {
        Optional<Category> category = categoryDAO.findById(code);
        if(category.isPresent()) {
            return category.get();
        }else {
            return null;
        }
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryDAO.save(category);
    }

    @Override
    public Category getCategoryByName(String name) {
        Optional<Category> category = categoryDAO.findByName(name);
        if(category.isPresent()) {
            return category.get();
        }else {
            return null;
        }
    }

    @Override
    public void deleteCategoryByCode(Long code) {
        categoryDAO.deleteById(code);
    }

    @Override
    public void deleteAll(){
        categoryDAO.deleteAll();
    }
}
