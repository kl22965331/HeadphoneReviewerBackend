package com.example.demo.Service;

import com.example.demo.Entity.Comment;
import java.util.*;
public interface CommentService {
    public List<Comment> getCommentsByReviewId(int id);
    public void addComment(Comment comment);
}
