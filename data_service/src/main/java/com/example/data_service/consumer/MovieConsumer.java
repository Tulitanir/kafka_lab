package com.example.data_service.consumer;

import com.example.data_service.dto.MovieDto;
import com.example.data_service.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieConsumer {
    private final ObjectMapper objectMapper;
    private final MovieService movieService;

    @SneakyThrows
    @KafkaListener(topics = "movie-topic", groupId = "group-1")
    public void consume(String message) {
        MovieDto movieDto = objectMapper.readValue(message, MovieDto.class);
        movieService.save(movieDto);
    }
}
