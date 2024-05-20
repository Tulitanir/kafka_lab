package com.example.api_service.controller;

import com.example.api_service.dto.MovieDto;
import com.example.api_service.producer.MovieProducer;
import com.example.api_service.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movie")
public class MovieController {
    private final MovieService movieService;
    private final MovieProducer movieProducer;

    @GetMapping
    public ResponseEntity<?> getById(@RequestParam Long id) {
        try {
            return ResponseEntity.ok(movieService.getById(id));
        }
        catch (HttpClientErrorException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<MovieDto>> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }

    @PostMapping
    public ResponseEntity<String> addMovie(@RequestBody MovieDto movieDto) {
        movieProducer.sendMessage(movieDto);
        return ResponseEntity.ok("Сообщение отправлено");
    }
}
