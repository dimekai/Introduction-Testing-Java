package movies.service;

import java.util.Collection;
import java.util.stream.Collectors;
import movies.data.MovieRepository;
import movies.model.*;

/**
 *
 * @author Jesus Diaz
 */
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        return this.movieRepository.findAll().stream()
                .filter(movie -> movie.getGenre() == genre).collect(Collectors.toList());
    }

    public Collection<Movie> findMoviesByTime(int minutes) {
        return this.movieRepository.findAll().stream()
                .filter(movie -> movie.getMinutes() <= minutes).collect(Collectors.toList());
    }
    
    public Collection<Movie> findMovieByName(String name) {
        return this.movieRepository.findAll().stream()
                .filter(movie -> movie.getName().toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
    }
    
    public Collection<Movie> findMovieByDirector(String director) {
        return this.movieRepository.findAll().stream()
                .filter(movie -> movie.getDirector().toLowerCase().contains(director.toLowerCase())).collect(Collectors.toList());
    }

}
