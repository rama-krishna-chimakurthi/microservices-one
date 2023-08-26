package com.movierating.ratingdataservice.controller;

import java.util.Arrays;
import java.util.List;

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

    @GetMapping("user/{userId}")
    public List<Rating> getRatingsForUser(){
        return Arrays.asList(
            new Rating("123", 5),
            new Rating("124", 4));
    }
}
