package com.example.data_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Genre {
    @Id
    @GeneratedValue(generator = "genre_id", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;

    public Genre(String name) {
        this.name = name;
    }
}
