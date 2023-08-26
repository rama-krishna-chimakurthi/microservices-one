package com.movierating.movieinfoservice.controller.dto;

public class Movie {
    private String movieName;
    private String movieDescription;
    private int movieId;

    public Movie(String movieName, String movieDescription, int movieId) {
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

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

}
