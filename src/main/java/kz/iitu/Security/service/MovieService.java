package kz.iitu.Security.service;

import kz.iitu.Security.entity.Movie;
import kz.iitu.Security.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    Movie movie = new Movie();

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public void saveMovie(Movie movie){
        this.movieRepository.save(movie);
    }

    public Movie getMovieById(Long id){
        Optional<Movie> optional = movieRepository.findById(id);
        Movie movie = null;
        if (optional.isPresent())
            movie =optional.get() ;
        else
        {throw new RuntimeException("no such movie : "+ id);}
        return movie;
    }

    public void deleteMovie(Long id){
        this.movieRepository.deleteById(id);
    }
}