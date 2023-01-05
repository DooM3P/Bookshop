package com.example.Bookshop.controller;

import com.example.Bookshop.models.Book;
import com.example.Bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This means that this class is a Controller
@RequestMapping(path="/api/books") // This means URL's start with /demo (after Application path)
public class BookController {
    @Autowired // This means to get the bean called BookService
    // Which is auto-generated by Spring, we will use it to handle the data
    private BookService bookService;

    @GetMapping(path = "/")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping(path = "/")
    @ResponseBody
    public void savedBook(@RequestBody Book book){
            //@RequestParam(value = "Title", defaultValue = "Fondation") String title,
            //@RequestParam(value = "Author", defaultValue = "Isaac Asimov") String author,
            //@RequestParam(value = "Price", defaultValue = "18") float price
        //Book book = new Book(title, author, price);
        bookService.saveBook(book);
        System.out.println(book.getTitle()+" saved");
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