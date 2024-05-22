package com.example.data_service.service;

import com.example.data_service.dto.MovieComment;
import com.example.data_service.dto.MovieDto;
import com.example.data_service.dto.MovieGenre;
import com.example.data_service.dto.MovieRating;
import com.example.data_service.model.Movie;
import com.example.data_service.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final GenreService genreService;


    public MovieDto getById(Long id) {
        try {
            var movie = movieRepository.getReferenceById(id);
            return MovieDto
                    .builder()
                    .id(movie.getId())
                    .title(movie.getTitle())
                    .genre(movie.getGenre() == null ? "Жанр не указан" : movie.getGenre().getName())
                    .reviewDtoList(movie.getReviews())
                    .build();
        } catch (EntityNotFoundException exception) {
            throw new RuntimeException("Фильма с id " + id + " не существует");
        }
    }

    public void save(MovieDto movieDto) {
        var movie = new Movie();
        movie.setGenre(genreService.getByName(movieDto.getGenre()));
        movie.setTitle(movieDto.getTitle());

        movieRepository.save(movie);
    }

    public List<MovieDto> getAll() {
        var movies = movieRepository.findAll();

        return movies
                .stream()
                .map(movie ->
                        MovieDto
                                .builder()
                                .id(movie.getId())
                                .genre(movie.getGenre() == null ? "Жанр не указан" : movie.getGenre().getName())
                                .title(movie.getTitle())
                                .reviewDtoList(movie.getReviews())
                                .build()
                )
                .toList();
    }

    public List<MovieRating> getTop5HighRatedMovies() {
        List<Object[]> results = movieRepository.findTop5HighRatedMovies();
        return results.stream()
                .map(result -> new MovieRating((String) result[0], (Double) result[1]))
                .collect(Collectors.toList());
    }

    public List<MovieComment> getTopPopularMovies() {
        List<Object[]> results = movieRepository.findTopPopularMovies();
        return results.stream()
                .map(result -> new MovieComment((String) result[0], ((Long) result[1])))
                .collect(Collectors.toList());
    }

    public List<MovieGenre> getCountMoviesByGenre() {
        List<Object[]> results = movieRepository.countMoviesByGenre();
        return results.stream()
                .map(result -> new MovieGenre((String) result[0], (Long) result[1]))
                .collect(Collectors.toList());
    }
}
