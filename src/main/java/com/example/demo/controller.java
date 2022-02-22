package com.example.demo;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class controller {
    private List<Book> books;

    private BookService bookService;

    public controller(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAuthor) {
         return bookService.getBooks(bookAuthor);
    }

    @GetMapping("/api/books/{bookId}")
    public Book getBook(@PathVariable Integer bookId) {
        return this.bookService.getBook(bookId);
    }

    @PostMapping("/api/books")
    public List<Book> createBook(@RequestBody Book book){
        return this.bookService.createBook(book);
    }

    @DeleteMapping("/api/books/{bookId}")
    public void deleteBook(@PathVariable Integer bookId){
        this.bookService.deleteBook(bookId);
    }

    @PutMapping("/api/books/{bookId}")
    public List<Book> putBook(@PathVariable Integer bookId, @RequestBody Book book){
        return this.bookService.putBook(bookId, book);
    }
}

