package com.yodalorian.films.repository;

import com.yodalorian.films.model.Film;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepos extends CrudRepository<Film, Long> {

}
