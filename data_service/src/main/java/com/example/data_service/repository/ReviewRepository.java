package com.example.data_service.repository;

import com.example.data_service.dto.MovieComment;
import com.example.data_service.dto.MovieGenre;
import com.example.data_service.dto.MovieRating;
import com.example.data_service.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("SELECT r FROM review r WHERE r.movieId = ?1")
    List<Review> findAllByMovieId(Long movieId);
}
