package com.kacz.kam.MovieService.movie.service;

import com.kacz.kam.MovieService.movie.model.Movie;
import com.kacz.kam.MovieService.movie.model.MovieCategory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public List<Movie> getAllMovies(){
        Movie movie1 = new Movie(1L,"The Great Train Robbery", MovieCategory.Action);
        Movie movie2 = new Movie(2L,"The Intouchables", MovieCategory.Comedy);
        Movie movie3 = new Movie(3L,"The Revenant", MovieCategory.Thriller);
        return List.of(movie1, movie2, movie3);
    }

    public Movie getMovieById(Long id){
        Movie movie1 = new Movie(1L,"The Great Train Robbery", MovieCategory.Action);
        if (id == movie1.getId()){

        }

    }



}
