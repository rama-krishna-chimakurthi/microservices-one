package com.movierating.moviecatalogservice.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movierating.moviecatalogservice.dto.CatalogItem;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

    @GetMapping("{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {
        return Collections.singletonList(
                new CatalogItem("Transformers", "test Desc", 5));
    }

}
