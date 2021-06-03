package com.kacz.kam.MovieService.movie.model;

import javax.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean isAvailable;


    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private MovieCategory movieCategory;

    public Movie(Long id, String name, MovieCategory movieCategory, boolean available) {
        this.id = id;
        this.name = name;
        this.movieCategory = movieCategory;
        this.isAvailable = available;
    }

    public Movie() {
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

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
