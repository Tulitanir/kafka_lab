package com.example.api_service.service;

import com.example.api_service.dto.ReviewDto;
import com.example.api_service.producer.ReviewProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final RestTemplate restTemplate;
    private final ReviewProducer reviewProducer;

    public ReviewDto getById(Long id) {
        return restTemplate.getForObject("/review?id=%s".formatted(id), ReviewDto.class);
    }

    public List<ReviewDto> getAll(Long movieId) {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("/review/byMovieId?movieId=%s".formatted(movieId), ReviewDto[].class))).toList();
    }
}
