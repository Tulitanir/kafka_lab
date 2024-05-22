package com.example.api_service.dto;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
public class ReviewDto {
    @Nullable
    private Long id;
    private Long movieId;
    private String text;
    private Long rating;
}
