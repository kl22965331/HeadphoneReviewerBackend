package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

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

    @Column(columnDefinition ="MEDIUMBLOB")
    private byte[] image;

    @Column(nullable = false)
    private LocalDateTime createDateTime = LocalDateTime.now();


    @OneToMany(mappedBy = "headphone",cascade =CascadeType.REMOVE)
    @Lazy
    private List<Review> reviews;



    public Headphone() {
    }

    public Headphone(String name, String brand, int price,byte[] image) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.createDateTime = LocalDateTime.now();
        this.image=image;
    }

    public Headphone(int id, String name, String brand, int price, byte[] image, LocalDateTime createDateTime) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.image = image;
        this.createDateTime = createDateTime;
    }


}
