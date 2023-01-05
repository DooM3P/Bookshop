package com.example.Bookshop.DAO;

import com.example.Bookshop.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDAO extends CrudRepository<Book, Long> {

}
