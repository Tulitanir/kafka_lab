package com.example.api_service.dto;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDto {
    @Nullable
    private Long id;
    @Nonnull
    private String title;
    @Nonnull
    private String genre;

    @Nullable
    private List<ReviewDto> reviewDtoList;
}
