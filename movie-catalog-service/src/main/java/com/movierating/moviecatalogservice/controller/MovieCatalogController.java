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
import org.springframework.web.reactive.function.client.WebClient;

import com.movierating.moviecatalogservice.dto.CatalogItem;
import com.movierating.moviecatalogservice.dto.Movie;
import com.movierating.moviecatalogservice.dto.Rating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder webClientBuilder;

    @GetMapping("{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {

        List<Rating> ratings = Arrays.asList(
                new Rating("123", 5),
                new Rating("124", 4));

        // Using RestTemplate
        return ratings.stream().map(rating -> {
            Movie movie = restTemplate.getForObject("http://localhost:8082/movie/" +rating.getMovieId(), Movie.class);
            return new CatalogItem(movie.getMovieName(), movie.getMovieDescription(),rating.getRating());
        }).collect(Collectors.toList());
        

        // Using WebClient
        /* return ratings.stream().map(rating -> {
            Movie movie = webClientBuilder.build()
                    .get()
                    .uri("http://localhost:8082/movie/" + rating.getMovieId())
                    .retrieve()
                    .bodyToMono(Movie.class)
                    .block();

            return new CatalogItem(movie.getMovieName(), movie.getMovieDescription(), rating.getRating());
        }).collect(Collectors.toList()); */

        /*
         * return Collections.singletonList(
         * new CatalogItem("Transformers", "test Desc", 5));
         */
    }

}
