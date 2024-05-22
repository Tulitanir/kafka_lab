package com.example.data_service.repository;

import com.example.data_service.dto.MovieComment;
import com.example.data_service.dto.MovieGenre;
import com.example.data_service.dto.MovieRating;
import com.example.data_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT m.title, AVG(r.rating) as averageRating FROM Movie m JOIN m.reviews r GROUP BY m ORDER BY averageRating DESC LIMIT 5")
    List<Object[]> findTop5HighRatedMovies();

    @Query("SELECT m.title, COUNT(r) as reviewCount FROM Movie m JOIN m.reviews r GROUP BY m ORDER BY reviewCount DESC LIMIT 5")
    List<Object[]> findTopPopularMovies();

    @Query("SELECT g.name, COUNT(m) FROM Movie m JOIN m.genre g GROUP BY g.name")
    List<Object[]> countMoviesByGenre();
}
