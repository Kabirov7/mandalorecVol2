package com.yodalorian.films.service;

import com.yodalorian.films.model.Film;
import com.yodalorian.films.repository.FilmRepos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FilmService implements IFilmService {
    @Autowired
    private FilmRepos repository;

    @Override
    public List<Film> findAll() {
        var films = (List<Film>) repository.findAll();

        return films;
    }
}
