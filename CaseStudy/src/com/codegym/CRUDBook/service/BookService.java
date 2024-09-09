package com.codegym.CRUDBook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookService {
    private List<Book> books = new ArrayList<>();
    private int currentId = 1;

    public Book createBook(String title, String author) {
        Book book = new Book(currentId++, title, author);
        books.add(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public Book getBookById(int id) {
        return books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateBook(int id, String newTitle, String newAuthor) {
        Book book = getBookById(id);
        if (book != null) {
            book.setTitle(newTitle);
            book.setAuthor(newAuthor);
        }
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }
}
