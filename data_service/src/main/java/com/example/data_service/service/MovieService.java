package com.example.data_service.service;

import com.example.data_service.dto.MovieDto;
import com.example.data_service.model.Movie;
import com.example.data_service.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

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
                                .genre(movie.getGenre() == null ? "Жанр не указан" : movie.getGenre().getName())
                                .title(movie.getTitle())
                                .build()
                )
                .toList();
    }
}
