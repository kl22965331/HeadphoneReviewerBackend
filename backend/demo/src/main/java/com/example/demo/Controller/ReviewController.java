package com.example.demo.Controller;

import com.example.demo.DTO.ReviewDTO;
import com.example.demo.Entity.Review;
import com.example.demo.Entity.User;
import com.example.demo.Exception.CustomException;
import com.example.demo.Service.ReviewService;
import com.example.demo.Service.UserService;
import com.example.demo.Util.SecurityContextUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/review")
public class ReviewController {
    private ReviewService reviewService;
    private UserService userService;

    @Autowired
    public ReviewController(ReviewService reviewService, UserService userService) {
        this.reviewService = reviewService;
        this.userService = userService;
    }

    @GetMapping("/get/{id}")
    public Review getReview(@PathVariable int id){
        reviewService.viewsCountPlusOne(id);
        return reviewService.getReview(id);
    }
    @GetMapping("/getReviewsOrderByViewsCount")
    public List<ReviewDTO> getReviewsOrderByViewsCount(){
        List<Review> reviews = reviewService.getReviews();
        Collections.sort(reviews, Comparator.comparing(Review::getViewsCount).reversed());
        ArrayList<ReviewDTO> reviewDTOS = new ArrayList<>();
        for (Review review: reviews) {
            reviewDTOS.add(new ReviewDTO(review));
        }
        return reviewDTOS;
    }
    @GetMapping("/getReviewsByName")
    public List<Review> getReviewByUsername(@RequestParam String username){
        int id = userService.getUserByUsername(username).getId();
        return  reviewService.getReviewsById(id);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addNewReview(@RequestBody Review review, HttpServletRequest request){
        String  currentUsername = SecurityContextUtil.getCurrentUsername();
        User tempUser = userService.getUserByUsername(currentUsername);
        review.setUser(tempUser);

        reviewService.addNewReview(review);

        return new ResponseEntity<>("新增成功", HttpStatus.OK);
    }
    @PutMapping("/update")
    public void updateReview(@RequestBody Review review,HttpServletRequest request){
        String currentUsername = SecurityContextUtil.getCurrentUsername();
        reviewService.updateReview(review,currentUsername);
    }

    @DeleteMapping("/delete")
    public void deleteReview(@RequestParam int id,HttpServletRequest request){
        String currentUsername = SecurityContextUtil.getCurrentUsername();
        if(reviewService.getReview(id).getUser().getUsername().equals(currentUsername)){
            reviewService.deleteReviewById(id);
        }else {
            throw new CustomException(403,"Invalid operation");
        }

    }
    @GetMapping("/getReviewsByHeadphone")
    public List<Review> getReviewsByHeadphoneId(@RequestParam int id){
        List<Review> reviews = reviewService.getReviewsByHeadphoneId(id);
        reviews.stream().forEach(review -> review.getUser().setReviews(null));
        reviews.stream().forEach(review -> review.getHeadphone().setReviews(null));
        return reviewService.getReviewsByHeadphoneId(id);
    }



}

