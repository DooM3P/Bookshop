package com.example.Bookshop.DAO;

import com.example.Bookshop.models.Book;
import com.example.Bookshop.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDAO extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByCategory(Category category);

}
