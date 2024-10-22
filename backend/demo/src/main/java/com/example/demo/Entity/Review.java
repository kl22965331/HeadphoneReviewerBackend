package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;

@Entity
@Table(name = "Review")
@Getter
@Setter
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName ="id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "headphone_id",referencedColumnName ="id")
    private Headphone headphone;

    @Column(nullable = false)
    private Integer rating;

    @Column(columnDefinition = "TEXT")
    @Lob
    private String comment;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Review() {
        
    }

    public Review(User user, Headphone headphone, Integer rating, String comment) {
        this.user = user;
        this.headphone = headphone;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", user=" + user +
                ", headphone=" + headphone +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
