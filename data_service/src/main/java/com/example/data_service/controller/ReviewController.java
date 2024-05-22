package com.example.data_service.controller;

import com.example.data_service.dto.ReviewDto;
import com.example.data_service.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(reviewService.getById(id));
        } catch (RuntimeException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/byMovieId")
    public ResponseEntity<List<ReviewDto>> getAll(@RequestParam Long movieId) {
        return ResponseEntity.ok(reviewService.getByMovieId(movieId));
    }
}
