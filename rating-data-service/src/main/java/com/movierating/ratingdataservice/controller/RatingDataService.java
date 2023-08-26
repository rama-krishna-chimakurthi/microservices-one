package com.movierating.ratingdataservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.ratingdataservice.dto.Rating;

@RestController
@RequestMapping("/rating")
public class RatingDataService {

    @GetMapping("{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return new Rating("123", 4);
    }
}
