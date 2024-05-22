package com.example.data_service.consumer;

import com.example.data_service.dto.MovieDto;
import com.example.data_service.dto.ReviewDto;
import com.example.data_service.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewConsumer {
    private final ObjectMapper objectMapper;
    private final ReviewService reviewService;

    @SneakyThrows
    @KafkaListener(topics = "review-topic", groupId = "group-1")
    public void consume(String message) {
        ReviewDto reviewDto = objectMapper.readValue(message, ReviewDto.class);
        reviewService.save(reviewDto);
    }
}
