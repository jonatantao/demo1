package com.example.demo;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<Book> books;

    public BookService(){
        this.books = init();
    }

    public List<Book> init( ){
        List<Book> books = new ArrayList<>();

        Book book1 = new Book();
        book1.setAuthor("Jozo");
        book1.setTitle("Ahoj");
        books.add(book1);

        Book book2 = new Book();
        book2.setAuthor("Fero");
        book2.setTitle("serus moj");
        books.add(book2);

        return books;

    }

    public List<Book> getBooks(String bookAutor) {
        if (bookAutor == null){
            return this.books;
        }

        List<Book> filteredBooks = new ArrayList<>();

        for(Book book : books){
            if (book.getAuthor().equals(bookAutor)){
                filteredBooks.add(book);
            }
        }

        return this.books;
    }

    public Book getBook(int bookId) {
        return this.books.get(bookId);
    }

    public List<Book> createBook(Book book){
        this.books.add(book);
        return this.books;
    }

    public void deleteBook(int bookId){
        this.books.remove(this.books.get(bookId));
    }

    public List<Book> putBook(int bookId, Book book){
        this.books.get(bookId).setAuthor(book.getAuthor());
        this.books.get(bookId).setTitle(book.getTitle());
        return books;
    }
}
