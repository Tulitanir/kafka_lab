package com.example.api_service.producer;

import com.example.api_service.dto.ReviewDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewProducer {
    private final KafkaTemplate<String, String> template;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessage(ReviewDto reviewDto) {
        String data = objectMapper.writeValueAsString(reviewDto);
        String key = UUID.randomUUID().toString();
        template.send("review-topic", key, data);
    }
}
