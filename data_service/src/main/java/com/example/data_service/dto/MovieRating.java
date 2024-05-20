package com.example.data_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRating {
    private String movieName;
    private String genre;
    private Double rating;
}
