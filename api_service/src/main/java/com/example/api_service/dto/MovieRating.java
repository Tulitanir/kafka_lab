package com.example.api_service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieRating {
    private String movieId;
    private String genre;
    private Double rating;
}
