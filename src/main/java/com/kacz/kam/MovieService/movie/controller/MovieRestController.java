package com.kacz.kam.MovieService.movie.controller;

import com.kacz.kam.MovieService.movie.model.Movie;
import com.kacz.kam.MovieService.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
    public ResponseEntity<List<Movie>> finaAllMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.findById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.save(movie));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @PutMapping("/movies/{id}/true")
    public ResponseEntity<Movie> changeAvailable(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.changeAvailable(id));
    }

    @PutMapping("/movies/{id}/false")
    public ResponseEntity<Movie> changeNotAvailable(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.changeNotAvailable(id));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

//  TODO: improve searching movie by the name
    @GetMapping("/movies/search")
    public List<Movie> search(@RequestParam("movieName") String theName, Model theModel){
        List<Movie> theMovies = movieService.searchBy(theName);
        theModel.addAttribute("movies", theMovies);
        return theMovies;
    }






}
