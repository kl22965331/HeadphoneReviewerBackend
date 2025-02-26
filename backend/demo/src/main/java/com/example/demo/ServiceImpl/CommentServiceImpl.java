package com.example.demo.ServiceImpl;

import com.example.demo.DAO.CommentRepository;
import com.example.demo.Entity.Comment;
import com.example.demo.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }




    @Override
    public List<Comment> getCommentsByReviewId(int id) {

        return commentRepository.findCommentsByUserId(id);
    }

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment);
    }
}
