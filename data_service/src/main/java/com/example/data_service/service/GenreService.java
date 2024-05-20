package com.example.data_service.service;

import com.example.data_service.model.Genre;
import com.example.data_service.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private Map<String, Genre> genreMap;

    public Genre getByName(String name) {
        if (genreMap == null)
            genreMap = getGenres();

        return genreMap.get(name);
    }

    private Map<String, Genre> getGenres() {
        Map<String, Genre> map = new HashMap<>();
        var genres = genreRepository.findAll();

        if (genres.isEmpty()) {
            List<Genre> initGenres = List.of(new Genre("ACTION"), new Genre("DRAMA"), new Genre("COMEDY"), new Genre("HORROR"), new Genre("SCI_FI"));
            genreRepository.saveAll(initGenres);
            genres = genreRepository.findAll();
        }

        for (Genre genre : genres) {
            map.put(genre.getName(), genre);
        }

        System.out.println(map);
        return map;
    }
}
