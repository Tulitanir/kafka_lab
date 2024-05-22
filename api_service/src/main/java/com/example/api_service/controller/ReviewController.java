package com.example.api_service.controller;

import com.example.api_service.dto.MovieDto;
import com.example.api_service.dto.ReviewDto;
import com.example.api_service.producer.ReviewProducer;
import com.example.api_service.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/review")
public class ReviewController {
    private final ReviewService reviewService;
    private final ReviewProducer reviewProducer;

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(reviewService.getById(id));
        }
        catch (HttpClientErrorException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/byMovieId")
    public ResponseEntity<List<ReviewDto>> getAll(@RequestParam Long movieId) {
        return ResponseEntity.ok(reviewService.getAll(movieId));
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestBody ReviewDto reviewDto) {
        reviewProducer.sendMessage(reviewDto);
        return ResponseEntity.ok("Сообщение отправлено");
    }
}
