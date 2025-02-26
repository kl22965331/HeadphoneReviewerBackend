package com.example.demo.Entity;


import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

import java.lang.annotation.Annotation;
import java.time.LocalDateTime;

@Entity
@Table(name = "Review")
@Getter
@Setter
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,name = "title")

    private String title;

    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName ="id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "headphone_id",referencedColumnName ="id")
    private Headphone headphone;

    @Column(nullable = false)
    @Max(100)
    @Min(0)
    private Integer rating;

    @Column(name ="comment",columnDefinition = "TEXT")
    @Lob
    private String comment;

    @Column(name = "created_at", updatable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "views_count")
    private int viewsCount;

    public Review() {
        
    }

    public Review(String title,User user, Headphone headphone, Integer rating, String comment) {
        this.title=title;
        this.user = user;
        this.headphone = headphone;
        this.rating = rating;
        this.comment = comment;
        this.createdAt = LocalDateTime.now();
        this.viewsCount=0;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", headphone=" + headphone +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
