package com.example.data_service.dto;

import com.example.data_service.model.Review;
import jakarta.annotation.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Getter
@Setter
@Builder
public class MovieDto {
    @Nullable
    private Long id;
    private String title;
    private String genre;

    @Nullable
    private List<Review> reviewDtoList;
}
