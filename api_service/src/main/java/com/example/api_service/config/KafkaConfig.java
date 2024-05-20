package com.example.api_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic testTopic() {
        return TopicBuilder
                .name("test-topic")
                .partitions(1)
                .build();
    }

    @Bean
    public NewTopic movieTopic() {
        return TopicBuilder
                .name("movie-topic")
                .partitions(1)
                .build();
    }

    @Bean
    public NewTopic reviewTopic() {
        return TopicBuilder
                .name("review-topic")
                .partitions(1)
                .build();
    }
}
