package movies.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.Before;
import org.mockito.Mockito;

import movies.data.MovieRepository;
import movies.model.*;

/**
 *
 * @author Jesus Diaz
 */
public class MovieServiceTest {

    private MovieRepository movieRepository;
    private List<Movie> allMovies;
    private MovieService movieService;
    private Collection<Movie> movies;

    @Before
    public void setup() {
        movieRepository = Mockito.mock(MovieRepository.class);

        allMovies = Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                new Movie(3, "Kill Bill", 100, Genre.ACTION, "Quentin Tarantino"),
                new Movie(4, "Scream", 111, Genre.HORROR, "Wes Craven"),
                new Movie(5, "Home Alone", 103, Genre.COMEDY, "Chris Columbus"),
                new Movie(6, "Evil Dead", 120, Genre.HORROR, "Sam Raimi"),
                new Movie(7, "Super 8", 112, Genre.THRILLER, "Jeffrey Jacob Abrams"),
                new Movie(8, "Matrix", 136, Genre.ACTION, "Lilly Wachowski"),
                new Movie(9, "Superman", 120, Genre.ACTION, "Richard Donner"),
                new Movie(10, "Jackie Brown", 110, Genre.ACTION, "Quentin Tarantino"),
                new Movie(11, "Resident Evil", 140, Genre.ACTION, "Paul William Scott Anderson"),
                new Movie(12, "Mortal Kombat", 130, Genre.ACTION, "Paul William Scott Anderson"),
                new Movie(13, "There's Something About Mary", 119, Genre.COMEDY, "Bobby Farrelly")
        );
        Mockito.when(movieRepository.findAll()).thenReturn(allMovies);
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void search_movie_by_genre() {
        movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(), is(Arrays.asList(5, 13)));
    }

    @Test
    public void search_movie_by_time() {
        movies = movieService.findMoviesByTime(119);
        
        assertThat(getMovieIds(), is(Arrays.asList(2, 3, 4, 5, 7, 10, 13)));
    }
    
    @Test
    public void search_movie_by_name() {
        movies = movieService.findMovieByName("Super");
        
        assertThat(getMovieIds(), is(Arrays.asList(7, 9)));
    }
    
    @Test
    public void search_movie_by_director() {
        movies = movieService.findMovieByDirector("Tarantino");
        
        assertThat(getMovieIds(), is(Arrays.asList(3, 10)));
    }

    private List<Integer> getMovieIds() {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
    
}
