package com.movierating.movieinfoservice.controller.dto;

public class Movie {
    private String movieName;
    private String movieDescription;
    private String movieId;

    public Movie(String movieName, String movieDescription, String movieId) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Movie [movieName=" + movieName + ", movieDescription=" + movieDescription + ", movieId=" + movieId
                + "]";
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

}
