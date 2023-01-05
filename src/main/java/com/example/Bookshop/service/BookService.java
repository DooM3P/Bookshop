package com.example.Bookshop.service;

import com.example.Bookshop.models.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();

    Book getBookByID(Long id);

    void deleteByID(Long id);

    void deleteAll();

    Book saveBook(Book book);

    Book updateBook(Long id, Book book);

}

