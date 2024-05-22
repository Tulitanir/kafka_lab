package com.example.data_service.service;

import com.example.data_service.dto.ReviewDto;
import com.example.data_service.model.Review;
import com.example.data_service.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewDto getById(Long id) {
        try {
            var review = reviewRepository.getReferenceById(id);
            return ReviewDto
                    .builder()
                    .id(review.getId())
                    .movieId(review.getMovieId())
                    .text(review.getText())
                    .rating(review.getRating())
                    .build();
        } catch (EntityNotFoundException exception) {
            throw new RuntimeException("Обзора с id " + id + " не существует");
        }
    }

    public List<ReviewDto> getByMovieId(Long movieId) {
        var reviews = reviewRepository.findAllByMovieId(movieId);

        return reviews
                .stream()
                .map(review ->
                        ReviewDto
                                .builder()
                                .id(review.getId())
                                .movieId(review.getMovieId())
                                .text(review.getText())
                                .rating(review.getRating())
                                .build()
                )
                .toList();
    }

    public void save(ReviewDto reviewDto) {
        var review = new Review();
        review.setText(reviewDto.getText());
        review.setRating(reviewDto.getRating());
        review.setMovieId(reviewDto.getMovieId());

        reviewRepository.save(review);
    }
}
