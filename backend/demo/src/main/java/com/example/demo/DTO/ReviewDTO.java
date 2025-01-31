package com.example.demo.DTO;


import com.example.demo.Entity.Review;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDateTime;


@Component
@Getter
@Setter
public class ReviewDTO implements Serializable {
    private int id;
    private String title;
    private int userId;
    private int headphoneId;
    private Integer rating;
    private String comment;
    private LocalDateTime createdAt;
    private int viewsCount;

    public ReviewDTO() {
    }

    public ReviewDTO(Review review) {
        this.id= review.getId();
        this.title= review.getTitle();
        this.userId=review.getUser().getId();
        this.headphoneId=review.getHeadphone().getId();
        this.rating=review.getRating();
        this.comment= review.getComment();
        this.createdAt=review.getCreatedAt();
        this.viewsCount= review.getViewsCount();
    }

    @Override
    public String toString() {
        return "ReviewDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", headphoneId=" + headphoneId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                ", viewsCount=" + viewsCount +
                '}';
    }
}
