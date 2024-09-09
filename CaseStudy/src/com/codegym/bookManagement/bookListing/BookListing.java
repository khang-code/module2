package com.codegym.bookManagement.bookListing;

import com.codegym.entity.Book;
import java.util.List;

public class BookListing {

    public static void listBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available.");
        } else {
            System.out.println("Books List:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }
}
