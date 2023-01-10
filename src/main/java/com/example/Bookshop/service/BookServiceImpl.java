package com.example.Bookshop.service;

import com.example.Bookshop.DAO.BookDAO;
import com.example.Bookshop.models.Book;

import com.example.Bookshop.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookDAO bookDAO;

    @Override
    public List<Book> getBooks() {
        List<Book> BOOKS = (List<Book>) bookDAO.findAll();
        if(!BOOKS.isEmpty()){
            return BOOKS;
        }else {
            return null;
        }
    }

    @Override
    public Book getBookByID(Long id) {
        Optional<Book> _book = bookDAO.findById(id);
        if(_book.isPresent()) {
            return _book.get();
        }else {
            return null;
        }
    }
    @Override
    public Book saveBook(Book book){
        //Book _book = new Book();
        //_book.setTitle(book.getTitle());
        //_book.setAuthor(book.getAuthor());
        //_book.setPrice(book.getPrice());
        //_book.setCategory(book.getCategory());
        //bookDAO.save(_book);
        //return _book;
        return bookDAO.save(book); // plus rapide mais bon...
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Optional<Book> retrievedBook = bookDAO.findById(id);
        bookDAO.save(retrievedBook.get());
        return retrievedBook.get();
    }

    @Override
    public List<Book> getBooksByCategory(Category category) {
        List<Book> books = bookDAO.findByCategory(category);
        if(!books.isEmpty()){
            return books;
        }
        return null;
    }

    @Override
    public void deleteByID(Long id) {
        bookDAO.deleteById(id);
    }

    @Override
    public void deleteAll() {
        bookDAO.deleteAll();
    }


}
