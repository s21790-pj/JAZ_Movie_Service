package com.kacz.kam.MovieService.movie.model;

public class Movie {

    private Long id;
    private String name;
    private MovieCategory movieCategory;

    public Movie(Long id, String name, MovieCategory movieCategory) {
        this.id = id;
        this.name = name;
        this.movieCategory = movieCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovieCategory getMovieCategory() {
        return movieCategory;
    }

    public void setMovieCategory(MovieCategory movieCategory) {
        this.movieCategory = movieCategory;
    }
}
