package com.example.api_service.service;

import com.example.api_service.dto.MovieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final RestTemplate restTemplate;
    public MovieDto getById(Long id) {
        return restTemplate.getForObject("/movie?id=%s".formatted(id), MovieDto.class);
    }

    public List<MovieDto> getAll() {
        return Arrays.stream(Objects.requireNonNull(restTemplate.getForObject("/movie/all", MovieDto[].class))).toList();
    }
}
