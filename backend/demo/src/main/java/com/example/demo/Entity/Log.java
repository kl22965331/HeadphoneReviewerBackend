package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name ="Log")
@Getter
@Setter
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String level;

    private String message;
    private LocalDateTime timeStamp;

    public Log() {
    }

    public Log(String level, String message,LocalDateTime timeStamp) {
        this.level = level;
        this.message = message;
        this.timeStamp=timeStamp;
    }
}
