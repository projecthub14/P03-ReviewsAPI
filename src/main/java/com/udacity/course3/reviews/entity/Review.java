package com.udacity.course3.reviews.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="review_id")
    private int reviewId;

    @Column(name="review_text")
    private String reviewText;

    @OneToMany(mappedBy="review",cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Comment> comments;


    @ManyToOne
    @JoinColumn(name="review_product_id")
    private Product product;


    public int getReviewId() {
        return reviewId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setReviews(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewText='" + reviewText + '\'' +
                '}';
    }
}
