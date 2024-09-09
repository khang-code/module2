package com.codegym.reviewManagement;

import java.util.ArrayList;
import java.util.List;

// Class to represent a Review
class Review {
    private String reviewerName;
    private String reviewText;
    private int rating; // Assuming rating is an integer from 1 to 5

    public Review(String reviewerName, String reviewText, int rating) {
        this.reviewerName = reviewerName;
        this.reviewText = reviewText;
        this.rating = rating;
    }

    // Getters and toString() method
    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Review by " + reviewerName + ": " + reviewText + " (Rating: " + rating + ")";
    }
}

