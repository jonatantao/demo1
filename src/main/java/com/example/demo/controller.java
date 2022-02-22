package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class controller {


    List<Book> books;
    public controller(){
        this.books = init();
    }

    public List<Book> init( ){
        List<Book> books = new ArrayList<>();
        Book book1 = new Book();
        book1.setAutors("Jozo");
        book1.setTitle("Ahoj");
        books.add(book1);

        Book book2 = new Book();
        book2.setAutors("Fero");
        book2.setTitle("serus moj");
        books.add(book2);

        return books;

    }

    @GetMapping("/api/books")
    public List<Book> getBooks(@RequestParam(required = false) String bookAutor) {

         List<Book> filteredBooks = new ArrayList<>();

         for(Book book : books){
             if (book.getAutors().equals(bookAutor)){
                 filteredBooks.add(book);
             }
         }



         return this.books;
    }
    @GetMapping("/api/books/{bookId}")
    public Book getBook(@PathVariable Integer bookId) {
        return this.books.get(bookId);
    }
}

