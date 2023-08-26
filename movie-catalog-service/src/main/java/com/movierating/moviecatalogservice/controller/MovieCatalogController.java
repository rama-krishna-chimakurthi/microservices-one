package com.movierating.moviecatalogservice.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movierating.moviecatalogservice.dto.CatalogItem;
import com.movierating.moviecatalogservice.dto.Movie;
import com.movierating.moviecatalogservice.dto.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("123", 5),
                new Rating("124", 4));

        return ratings.stream().map(rating -> {
            String url = "http://localhost:8082/movie/" + rating.getMovieId();
            Movie movie = restTemplate.getForObject(url, Movie.class);
            return new CatalogItem(movie.getMovieName(), movie.getMovieDescription(), rating.getRating());
        }).collect(Collectors.toList());

        /*
         * return Collections.singletonList(
         * new CatalogItem("Transformers", "test Desc", 5));
         */
    }

}
