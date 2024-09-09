package com.codegym.bookManagement.bookSorting;
import com.codegym.entity.Book;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookSorting {

    public static void sortBooksById(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getId));
        System.out.println("Books sorted by ID.");
    }

    public static void sortBooksByTitle(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getTitle));
        System.out.println("Books sorted by title.");
    }

    public static void sortBooksByAuthor(List<Book> books) {
        Collections.sort(books, Comparator.comparing(Book::getAuthor));
        System.out.println("Books sorted by author.");
    }
}