package com.codegym;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.codegym.bookManagement.bookListing.BookListing;
import com.codegym.bookManagement.bookSorting.BookSorting;
import com.codegym.entity.Book;
import com.codegym.reviewManagement.ReviewManagement;
import com.codegym.userManagement.LoginManager;

public class Menu {
    private LoginManager loginManager;
    private List<Book> books;
    private ReviewManagement reviewManagement;  // Added review management
    private static final String BOOK_FILE = "data/book.txt";

    public Menu() {
        loginManager = new LoginManager();
        books = new ArrayList<>();
        reviewManagement = new ReviewManagement();  // Initialize review management
        loadBooksFromFile();
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register");
            System.out.println("2. Login");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        System.out.println("Register System");
                        System.out.print("Enter Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        String password = scanner.nextLine();
                        loginManager.registerUser(username, password);
                        break;

                    case 2:
                        System.out.println("Login System");
                        System.out.print("Enter Username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter Password: ");
                        password = scanner.nextLine();
                        if (loginManager.loginUser(username, password)) {
                            handlePostLoginMenu();
                        }
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        saveBooksToFile();
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid option. Please choose 1, 2, or 6.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private void handlePostLoginMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n3. Add Book");
            System.out.println("4. List Books");
            System.out.println("5. Sort Books");
            System.out.println("6. Manage Reviews"); // Added manage reviews option
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 3:
                        System.out.println("Add Book");
                        System.out.print("Enter ID: ");
                        String id = scanner.nextLine();
                        System.out.print("Enter Title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter Author: ");
                        String author = scanner.nextLine();
                        System.out.print("Enter Type: ");
                        String type = scanner.nextLine();
                        addBook(id, title, author, type);
                        break;

                    case 4:
                        listBooks();
                        break;

                    case 5:
                        System.out.println("Sort Books");
                        System.out.println("1. By ID");
                        System.out.println("2. By Title");
                        System.out.println("3. By Author");
                        System.out.print("Choose sorting criterion: ");
                        int sortCriterion = scanner.nextInt();
                        scanner.nextLine(); // Consume newline left-over
                        sortBooks(sortCriterion);
                        break;

                    case 6:
                        handleReviewMenu();  // Handle review-related options
                        break;

                    case 7:
                        System.out.println("Exiting...");
                        saveBooksToFile();
                        return;

                    default:
                        System.out.println("Invalid option. Please choose 3, 4, 5, 7, or 6.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private void handleReviewMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Review");
            System.out.println("2. View Reviews");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline left-over

                switch (choice) {
                    case 1:
                        addReview();
                        break;

                    case 2:
                        reviewManagement.viewReviews();
                        break;

                    case 3:
                        return;  // Go back to the main post-login menu

                    default:
                        System.out.println("Invalid option. Please choose 1, 2, or 3.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    private void addBook(String id, String title, String author, String type) {
        books.add(new Book(id, title, author, type));
        System.out.println("Book added successfully!");
    }

    private void listBooks() {
        BookListing.listBooks(books);
    }

    private void sortBooks(int criterion) {
        switch (criterion) {
            case 1:
                BookSorting.sortBooksById(books);
                break;
            case 2:
                BookSorting.sortBooksByTitle(books);
                break;
            case 3:
                BookSorting.sortBooksByAuthor(books);
                break;
            default:
                System.out.println("Invalid sorting criterion.");
                return;
        }
        listBooks(); // Optionally list books after sorting
    }

    private void addReview() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter reviewer's name: ");
        String reviewerName = scanner.nextLine();

        System.out.print("Enter review text: ");
        String reviewText = scanner.nextLine();

        System.out.print("Enter rating (1 to 5): ");
        int rating = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        try {
            reviewManagement.addReview(reviewerName, reviewText, rating);
            System.out.println("Review added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadBooksFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(BOOK_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    books.add(new Book(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Could not load books from file.");
        }
    }

    private void saveBooksToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(BOOK_FILE))) {
            for (Book book : books) {
                writer.write(book.getId() + "," + book.getTitle() + "," + book.getAuthor() + "," + book.getType());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not save books to file.");
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.displayMenu();
    }
}
