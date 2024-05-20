package com.example.api_service.dto;

import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDto {
    @Nullable
    private Long id;
    private String title;
    private String genre;
}
