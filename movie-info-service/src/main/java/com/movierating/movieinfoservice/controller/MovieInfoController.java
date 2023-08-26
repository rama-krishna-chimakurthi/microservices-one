package com.movierating.movieinfoservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.movieinfoservice.controller.dto.Movie;

@RestController
@RequestMapping("/movie")
public class MovieInfoController {

    @GetMapping("{id}")
    public Movie getMovie(@PathVariable("id") String id) {
        return new Movie("Transformers", "Sci-fi", "123");
    }
}
