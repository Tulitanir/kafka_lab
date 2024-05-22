package com.example.data_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MovieGenre {
    private String genreName;
    private Long movieCount;
}
