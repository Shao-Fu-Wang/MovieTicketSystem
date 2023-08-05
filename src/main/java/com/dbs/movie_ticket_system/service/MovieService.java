package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> fetchMovieList();
    Movie saveMovie(Movie movie);
    Movie fetchMovieByName(String movieName);
    Movie updateMovie(Long movieId, Movie movie);
}
