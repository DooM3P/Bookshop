package com.example.Bookshop.DAO;

import com.example.Bookshop.models.Book;
import com.example.Bookshop.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryDAO extends CrudRepository<Category, Long> {
    Optional<Category> findByName(String name);
}
