package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks(){
       return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(
            @PathVariable Long id
    ){
        return  bookService.getBookById(id);
    }

    @PostMapping()
    public Book createBook(
            @RequestBody Book book
    ){
      return  bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook (
            @PathVariable Long id
    ){
        bookService.deleteBook(id);
    }
}
