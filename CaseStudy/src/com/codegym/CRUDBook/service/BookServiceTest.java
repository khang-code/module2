package com.codegym.CRUDBook.service;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BookServiceTest {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBook Service Menu:");
            System.out.println("1. Create a new book");
            System.out.println("2. View all books");
            System.out.println("3. View book by ID");
            System.out.println("4. Update book");
            System.out.println("5. Delete book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();  // Clear the buffer
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the title of the book: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the author of the book: ");
                    String author = scanner.nextLine();
                    Book newBook = bookService.createBook(title, author);
                    System.out.println("Book created: " + newBook);
                    break;

                case 2:
                    System.out.println("All Books: " + bookService.getAllBooks());
                    break;

                case 3:
                    System.out.print("Enter the ID of the book to view: ");
                    int viewId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    Book book = bookService.getBookById(viewId);
                    if (book != null) {
                        System.out.println("Book with ID " + viewId + ": " + book);
                    } else {
                        System.out.println("No book found with ID " + viewId);
                    }
                    break;

                case 4:
                    System.out.print("Enter the ID of the book to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    System.out.print("Enter the new title of the book: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter the new author of the book: ");
                    String newAuthor = scanner.nextLine();
                    bookService.updateBook(updateId, newTitle, newAuthor);
                    System.out.println("Book updated.");
                    break;

                case 5:
                    System.out.print("Enter the ID of the book to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();  // Consume the newline
                    bookService.deleteBook(deleteId);
                    System.out.println("Book deleted.");
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
}
