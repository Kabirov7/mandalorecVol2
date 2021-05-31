package com.yodalorian.films.service;
import com.yodalorian.films.model.Film;

import java.util.List;


public interface IFilmService {
    List<Film> findAll();
}
