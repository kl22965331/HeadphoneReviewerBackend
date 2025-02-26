package com.example.demo.Service;

import com.example.demo.Entity.Review;
import java.util.List;
public interface ReviewService {

    Review getReview(int id);
    void addNewReview(Review review);

    void updateReview(Review review, String updater);

    void deleteReviewById(int id);
    List<Review> getReviewsById(int id);

    List<Review> getReviewsByHeadphoneId(int id);

    void viewsCountPlusOne(int id);
    List<Review> getReviews();
}
