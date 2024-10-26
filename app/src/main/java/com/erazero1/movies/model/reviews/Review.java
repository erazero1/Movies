package com.erazero1.movies.model.reviews;

import com.google.gson.annotations.SerializedName;


public class Review {
    @SerializedName("id")
    private int reviewId;
    @SerializedName("movieId")
    private int movieId;
    @SerializedName("type")
    private String type;
    @SerializedName("review")
    private String review;
    @SerializedName("author")
    private String author;


    public Review(int reviewId, int movieId, String type, String review, String author) {
        this.reviewId = reviewId;
        this.movieId = movieId;
        this.type = type;
        this.review = review;
        this.author = author;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getType() {
        return type;
    }

    public String getReview() {
        return review;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", movieId=" + movieId +
                ", type='" + type + '\'' +
                ", review='" + review + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
