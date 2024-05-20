package com.example.api_service.controller;

import com.example.api_service.dto.TestDto;
import com.example.api_service.producer.TestProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {
    private final TestProducer testProducer;

    @PostMapping
    public void sendMessage(@RequestBody TestDto test) {
        testProducer.sendMessage(test);
    }
}
