package com.udacity.course3.reviews.entity;

import javax.persistence.*;

@Entity
@Table(name="comments")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="comment_id")
    private int commentId;

    @Column(name="comment_text")
    private String commentText;

    @ManyToOne
    @JoinColumn(name="comment_review_id")
    private Review review;

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", commentText='" + commentText + '\'' +
                ", review=" + review +
                '}';
    }
}
