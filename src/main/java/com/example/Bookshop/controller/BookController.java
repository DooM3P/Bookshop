package com.example.Bookshop.controller;

import com.example.Bookshop.models.Book;
import com.example.Bookshop.service.BookService;

import com.example.Bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/api/books") // This means URL's start with /demo (after Application path)
public class BookController {
    @Autowired // This means to get the bean called BookService
    // Which is auto-generated by Spring, we will use it to handle the data
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(path = "/")
    public ResponseEntity<List<Book>> getBooks(){
        try {
            List<Book> books = bookService.getBooks();
            return new ResponseEntity<>(books, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

    @PostMapping(path = "/")
    public ResponseEntity<Book> saveBook(@RequestBody Book book) {
        try {
            //if (book.getCategory() != null){
            //    System.out.println(book.getCategory());
            //}
            //book.setCategory(categoryService.getCategoryByCode(book.getCategory().getCode()));
            //System.out.println(book.getCategory().getName());
            return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookByID(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable Long id) {
        bookService.deleteByID(id);
    }

    @DeleteMapping(path = "/")
    public void deleteAll() {
        bookService.deleteAll();
    }

}