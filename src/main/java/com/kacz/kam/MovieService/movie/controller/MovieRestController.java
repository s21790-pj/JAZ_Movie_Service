package com.kacz.kam.MovieService.movie.controller;

import com.kacz.kam.MovieService.movie.model.Movie;
import com.kacz.kam.MovieService.movie.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class MovieRestController {

    private final MovieService movieService;

    public MovieRestController(MovieService movieService){
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity getMovieById(@PathVariable Long id){
        if(movieService.getMovieById(id)){
            return ResponseEntity.ok().build();
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addNewMovie(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable Long id){
        return ResponseEntity.ok(movieService.updateMovie(movie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.delteMovie(id);
        return ResponseEntity.noContent().build();
    }






}
