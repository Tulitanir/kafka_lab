package com.example.data_service.controller;

import com.example.data_service.dto.MovieComment;
import com.example.data_service.dto.MovieDto;
import com.example.data_service.dto.MovieGenre;
import com.example.data_service.dto.MovieRating;
import com.example.data_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(movieService.getById(id));
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @GetMapping("/topRating")
    public ResponseEntity<List<MovieRating>> topRating() {
        return ResponseEntity.ok(movieService.getTop5HighRatedMovies());
    }

    @GetMapping("/topComment")
    public ResponseEntity<List<MovieComment>> topComments() {
        return ResponseEntity.ok(movieService.getTopPopularMovies());
    }

    @GetMapping("/genreCount")
    public ResponseEntity<List<MovieGenre>> genreCount() {
        return ResponseEntity.ok(movieService.getCountMoviesByGenre());
    }
}
