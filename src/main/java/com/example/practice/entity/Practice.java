package com.example.practice.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Practice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String content;

    private String name;

    private LocalDateTime reg_date;

    private Integer hit;

    @PrePersist
    public void reg_date() {
        this.reg_date = LocalDateTime.now();
    }
}
