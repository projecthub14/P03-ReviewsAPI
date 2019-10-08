package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {


    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ReviewRepository reviewRepository;

    /**
     * Creates a comment for a review.
     *
     * 1. Add argument for comment entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, save comment.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
    public ResponseEntity<String> createCommentForReview(@PathVariable("reviewId") Integer reviewId,@RequestBody Comment comment) {
        Optional<Review> review = reviewRepository.findById(reviewId);

        Review theReview = null;

        if(review.isPresent()) {
            theReview = review.get();
            comment.setReview(theReview);

            commentRepository.save(comment);
            return new ResponseEntity<>(HttpStatus.CREATED);

        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }

    /**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public List<?> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
        Optional<Review> review = reviewRepository.findById(reviewId);

        Review theReview = null;

        if(review.isPresent()) {
            theReview = review.get();
            return theReview.getComments();
        }
        else{
            return Arrays.asList(HttpStatus.NOT_FOUND);
        }
    }
}