package com.example.api_service.producer;

import com.example.api_service.dto.MovieDto;
import com.example.api_service.dto.TestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MovieProducer {
    private final KafkaTemplate<String, String> template;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessage(MovieDto movieDto) {
        String data = objectMapper.writeValueAsString(movieDto);
        String key = UUID.randomUUID().toString();
        template.send("movie-topic", key, data);
    }
}
