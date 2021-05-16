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

    public Collection<Movie> findMoviesByTime(Integer minutes) {
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

    public Collection<Movie> templateFilter(Movie template, Collection<Movie> movies) {

        if (template.getGenre() != null) {
            movies = movies.stream()
                    .filter(movie -> movie.getGenre() == template.getGenre())
                    .collect(Collectors.toList());
        }

        if (template.getMinutes() != null && template.getMinutes() >= 0) {
            movies = movies.stream()
                    .filter(movie -> movie.getMinutes() <= template.getMinutes())
                    .collect(Collectors.toList());
        }

        if (template.getName() != null) {
            movies = movies.stream()
                    .filter(movie -> movie.getName().toLowerCase().contains(template.getName().toLowerCase()))
                    .collect(Collectors.toList());
        }

        if (template.getDirector() != null) {
            movies = movies.stream()
                    .filter(movie -> movie.getDirector().toLowerCase().contains(template.getDirector().toLowerCase()))
                    .collect(Collectors.toList());
        }

        return movies;

    }

    public Collection<Movie> findMovieByTemplate(Movie template) {

        Collection<Movie> movies = movieRepository.findAll();

        return (template.getId() == null)
                ? templateFilter(template, movies)
                : movies.stream().filter(movie -> movie.getId().equals(template.getId())).collect(Collectors.toList());
    }

}
