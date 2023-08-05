package com.dbs.movie_ticket_system.service;

import com.dbs.movie_ticket_system.entity.Movie;
import com.dbs.movie_ticket_system.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepository movieRepository;
    @Override
    public List<Movie> fetchMovieList(){
        return movieRepository.findAll();
    }

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie fetchMovieByName(String movieName) {
        return movieRepository.findByMovieNameIgnoreCase(movieName);
    }

    @Override
    public Movie updateMovie(Long movieId, Movie movie) {
        Movie movieDB = movieRepository.findById(movieId).get();
        if(Objects.nonNull(movie.getMovieName()) && !"".equalsIgnoreCase(movie.getMovieName())){
            movieDB.setMovieName(movie.getMovieName());
        }
        if(Objects.nonNull(movie.getMovieDatetime()) && !"".equalsIgnoreCase(movie.getMovieDatetime())){
            movieDB.setMovieDatetime(movie.getMovieDatetime());
        }
        if(Objects.nonNull(movie.getMovieOnboard()) && !"".equalsIgnoreCase(String.valueOf(movie.getMovieOnboard()))){
            movieDB.setMovieOnboard(movie.getMovieOnboard());
        }
        return movieRepository.save(movieDB);
    }

}
