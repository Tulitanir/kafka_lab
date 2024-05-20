package com.example.data_service.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    @Nullable
    private Long id;
    private Long movieId;
    private String text;

    @Min(0)
    @Max(10)
    private Short rating;
}
