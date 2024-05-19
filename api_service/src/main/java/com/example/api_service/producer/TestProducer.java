package com.example.api_service.producer;

import com.example.api_service.model.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestProducer {
    private final KafkaTemplate<String, String> template;
    private final ObjectMapper objectMapper;

    @SneakyThrows
    public void sendMessage(Test test) {
        String data = objectMapper.writeValueAsString(test);
        String key = UUID.randomUUID().toString();
        template.send("test-topic", key, data);
    }
}
