package com.example.data_service.dto;

import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class ReviewDto {
    @Nullable
    private Long id;
    private Long movieId;
    private String text;
    private Long rating;
}
