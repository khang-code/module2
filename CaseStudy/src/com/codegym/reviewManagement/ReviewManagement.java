package com.codegym.reviewManagement;

import java.util.ArrayList;
import java.util.List;

// Class to manage reviews for a book
public class ReviewManagement {
    private List<Review> reviews;

    public ReviewManagement() {
        this.reviews = new ArrayList<>();
    }

    // Add a new review
    public void addReview(String reviewerName, String reviewText, int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        reviews.add(new Review(reviewerName, reviewText, rating));
    }

    // View all reviews
    public void viewReviews() {
        if (reviews.isEmpty()) {
            System.out.println("No reviews yet.");
        } else {
            for (Review review : reviews) {
                System.out.println(review);
            }
        }
    }

    public static void main(String[] args) {
        ReviewManagement reviewManagement = new ReviewManagement();
        reviewManagement.addReview("Alice", "Great book!", 5);
        reviewManagement.addReview("Bob", "Not bad, but could be better.", 3);

        System.out.println("All Reviews:");
        reviewManagement.viewReviews();
    }
}
