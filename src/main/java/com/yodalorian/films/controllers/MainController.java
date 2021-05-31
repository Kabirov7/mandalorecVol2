package com.yodalorian.films.controllers;

import com.yodalorian.films.model.Film;
import com.yodalorian.films.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private IFilmService filmService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main page!");
        return "home";
    }

    @GetMapping("/showFilms")
    public String findFilms(Model model) {
        var films = (List<Film>) filmService.findAll();

        model.addAttribute("films", films);

        return "showFilms";
    }

}