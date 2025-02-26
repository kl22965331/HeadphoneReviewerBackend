package com.example.demo.Controller;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Review;
import com.example.demo.Entity.User;
import com.example.demo.Service.CommentService;
import com.example.demo.Service.UserService;
import com.example.demo.Util.SecurityContextUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;
    private UserService userService;

    @Autowired
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService;
    }



    @GetMapping("/commentsByReviewId")
    public List<Comment> getCommentsByReviewId(@RequestParam int id){
        return commentService.getCommentsByReviewId(id);
    }
    @PostMapping("/addNewComment")
    public ResponseEntity addComment(@RequestParam int reviewId,@RequestParam String comment, HttpServletRequest request){
        Comment tempComment = new Comment();
        String currentUsername = SecurityContextUtil.getCurrentUsername();
        User tempUser = userService.getUserByUsername(currentUsername);
        Review tempReview = new Review();
        tempReview.setId(reviewId);
        tempComment.setUser(tempUser);
        tempComment.setReview(tempReview);
        tempComment.setComment(comment);
        commentService.addComment(tempComment);
        return new ResponseEntity("新增評論成功", HttpStatus.OK);
    }
}
