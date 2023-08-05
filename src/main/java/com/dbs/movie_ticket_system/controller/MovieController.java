package com.dbs.movie_ticket_system.controller;

import com.dbs.movie_ticket_system.entity.Movie;
import com.dbs.movie_ticket_system.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;
    private final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    @GetMapping("/movies")
    public List<Movie> fetchMovieList() {
        LOGGER.info("fetched");
        return movieService.fetchMovieList();
    }

    @GetMapping("/movies/name/{name}")
    public Movie fetchMovieByName(@PathVariable("name") String movieName) {
        return movieService.fetchMovieByName(movieName);
    }


    @PostMapping("/movies")
    public Movie uploadMovie(@RequestBody Movie movie) {
        LOGGER.info("uploading movie");
        return movieService.saveMovie(movie);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable("id") Long movieId,
                             @RequestBody Movie movie) {
        return movieService.updateMovie(movieId, movie);
    }

    @PutMapping("/movies/admin/ondeboard/{movie_name}")
    public Movie ondeboardMovie(@PathVariable("movie_name") String movieName) {
        Movie movie = movieService.fetchMovieByName(movieName);
        movie.setMovieOnboard(!movie.getMovieOnboard());
        return movieService.updateMovie(movie.getMovieId(), movie);
    }
}
