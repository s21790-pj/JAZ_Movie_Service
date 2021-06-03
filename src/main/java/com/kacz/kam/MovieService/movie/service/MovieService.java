package com.kacz.kam.MovieService.movie.service;

import com.kacz.kam.MovieService.movie.model.Movie;
import com.kacz.kam.MovieService.movie.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public Movie findById(Long id){
        Optional<Movie> searchMovie = movieRepository.findById(id);
        if (searchMovie.isPresent()) {
            return searchMovie.get();
        } else {
            throw new RuntimeException();
        }
    }

    public List<Movie> findAll(){
        return movieRepository.findAll();
    }

    public Movie save(Movie theMovie){
        return movieRepository.save(theMovie);
    }

    public Movie updateMovie(Long id, Movie movie) {
        Optional<Movie> updateMovieInDB = movieRepository.findById(id);
        if(updateMovieInDB.isPresent()) {
            Movie addNewMovie = movie;
            addNewMovie.setId(id);
            return movieRepository.save(addNewMovie);
        } else {
            throw new RuntimeException();
        }
    }

    public Movie changeAvailable(Long id) {
        Optional<Movie> booleanMovie = movieRepository.findById(id);
        if(booleanMovie.isPresent()) {
            booleanMovie.get().setAvailable(true);
            return movieRepository.save(booleanMovie.get());
        } else {
            throw new RuntimeException();
        }
    }

    public void deleteById(Long id){
        movieRepository.deleteById(id);
    }

//  TODO: improve searching movie by the name
    public List<Movie> searchBy(String theName){
        List<Movie> result = null;

        if (theName != null && (theName.trim().length() > 0)){
            result = movieRepository.findByNameContainsAllIgnoreCase(theName);
        }
        else {
            result = findAll();
        }
        return result;
    }
}




