package com.example.demo.ServiceImpl;

import com.example.demo.DAO.ReviewRepository;
import com.example.demo.Entity.Review;
import com.example.demo.Exception.CustomException;
import com.example.demo.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review getReview(int id) {
        Optional<Review> optionalReview = reviewRepository.findById(id);
        if(optionalReview.isPresent()){
            return optionalReview.get();
        }else {
            throw  new CustomException("該Review已被刪除或不存在");
        }
    }

    @Override
    public void addNewReview(Review review) {
        if(isUserIdAndHeadPhoneIdPresent(review)){
            throw new CustomException("repeated operation");
        }else {
            reviewRepository.save(review);
        }
    }




    public void updateReview(Review review, String updaterName) {
        Optional<Review> optionalReview= reviewRepository.findById(review.getId());
        if(optionalReview.isPresent()){
            Review dBreview = optionalReview.get();
            if(dBreview.getId()==review.getId()&& dBreview.getUser().getUsername().equals(updaterName)){
                reviewRepository.save(review);
            }

        }else {
            throw new CustomException("更新失敗");
        }
    }

    @Override
    public void deleteReviewById(int id) {

        if(reviewRepository.existsById(id)){
            reviewRepository.deleteById(id);
        }else {
            throw new CustomException("刪除失敗,該review不存在");
        }
    }

    @Override
    public List<Review> getReviewsById(int id) {
        return reviewRepository.getReviewsByUserId(id);

    }

    @Override
    public List<Review> getReviewsByHeadphoneId(int id) {
        return reviewRepository.getReviewsByHeadphone(id);
    }

    @Override
    public void viewsCountPlusOne(int id) {
        reviewRepository.viewsCountPlusOne(id);
    }

    @Override
    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    private boolean isUserIdAndHeadPhoneIdPresent(Review review) {
        ExampleMatcher reviewMatcher = ExampleMatcher.matching()
                .withIgnoreCase("user.id","headphone.id")
                .withIgnorePaths("id","title","rating","comment","createdAt")
                .withIgnoreCase();
        Example<Review> reviewExample = Example.of(review, reviewMatcher);
        return reviewRepository.exists(reviewExample);
    }
}
