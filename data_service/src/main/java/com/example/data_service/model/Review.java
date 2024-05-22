package com.example.data_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "review")
@Getter
@Setter
@ToString
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private Long movieId;
    private String text;
    private Long rating;
}
