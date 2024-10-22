package com.example.demo.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.*;
@Entity
@Table(name = "Headphone")
@Getter
@Setter
public class Headphone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
    private String brand;

    @Column(nullable = false)
    private int price;

    @Column(name = "reviewscount", nullable = false)
    private int reviewsCount;

    @Column(name = "createdDateTime",nullable = false)
    private LocalDateTime createDateTime = LocalDateTime.now();

    @OneToMany(mappedBy = "headphone",cascade =CascadeType.REMOVE)
    private List<Review> reviews;



    public Headphone() {
    }

    public Headphone(String name, String brand, int price) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.reviewsCount =0;
        this.createDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Headphone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", reviewsCount=" + reviewsCount +
                ", createDateTime=" + createDateTime +
                ", reviews=" + reviews +
                '}';
    }
}
