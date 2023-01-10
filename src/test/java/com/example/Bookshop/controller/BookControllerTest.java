package com.example.Bookshop.controller;

import com.example.Bookshop.models.Book;
import com.example.Bookshop.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(org.mockito.junit.MockitoJUnitRunner.class)
public class BookControllerTest {
    @InjectMocks
    private BookController bookController;

    @Mock
    private BookService bookService;

    @Test
    public void getBooks_withoutException(){

        //Given
        List<Book> list = new ArrayList<>();

        Book firstBook = new Book();
        Book secondBook = new Book();

        list.add(secondBook);
        list.add(firstBook);

        //When
        when(bookService.getBooks()).thenReturn(list);
        ResponseEntity<List<Book>> resultat = bookController.getBooks();

        //Then
        assertEquals(2, resultat.getBody().size());
        assertEquals(HttpStatus.OK, resultat.getStatusCode());

    }
    @Test(expected = NullPointerException.class)
    public void getBooks_withException(){
        when(bookService.getBooks()).thenThrow(new NullPointerException("Error occurred"));

        //then
        assertTrue(bookController.getBooks().getStatusCode()==HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    public void deleteBooksTest() throws Exception {
        //given
        Book book = new Book();
        book.setId(2L);
        book.setTitle("Hhhh");
        book.setAuthor("Gilles H");
        book.setPrice(30);

        //when

        Mockito.when(bookService.saveBook(book)).thenReturn(book);
        bookController.saveBook(book);
        bookController.deleteAll();

        ResponseEntity<Book> response = bookController.getBookById(2L);

        //then
        assertThat(response.getBody()).isNull();

    }
}
