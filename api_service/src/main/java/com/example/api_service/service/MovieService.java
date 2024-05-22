package com.example.api_service.service;

import com.example.api_service.dto.MovieComment;
import com.example.api_service.dto.MovieDto;
import com.example.api_service.dto.MovieGenre;
import com.example.api_service.dto.MovieRating;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final RestTemplate restTemplate;

    public MovieDto getById(Long id) {
        return restTemplate.getForObject("/movie?id=%s".formatted(id), MovieDto.class);
    }

    public List<MovieDto> getAll() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("/movie/all", MovieDto[].class))).toList();
    }

    public List<MovieRating> getTop5HighRatedMovies() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("/movie/topRating", MovieRating[].class))).toList();
    }

    public List<MovieComment> getTopPopularMovies() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("/movie/topComment", MovieComment[].class))).toList();
    }

    public List<MovieGenre> getCountMoviesByGenre() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("/movie/genreCount", MovieGenre[].class))).toList();
    }
}
