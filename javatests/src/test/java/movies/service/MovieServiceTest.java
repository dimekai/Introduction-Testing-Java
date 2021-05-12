package movies.service;

import static org.hamcrest.CoreMatchers.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import movies.data.MovieRepository;
import movies.model.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.mockito.Mockito;

/**
 *
 * @author Jesus Diaz
 */
public class MovieServiceTest {

    private MovieRepository movieRepository;
    private List<Movie> allMovies;
    private MovieService movieService;
    private Collection<Movie> movies;

    public MovieServiceTest() {
    }

    @Before
    public void setup() {
        movieRepository = Mockito.mock(MovieRepository.class);

        allMovies = Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "There's Something About Mary", 119, Genre.COMEDY),
                new Movie(4, "Super 8", 112, Genre.THRILLER),
                new Movie(5, "Scream", 111, Genre.HORROR),
                new Movie(6, "Home Alone", 103, Genre.COMEDY),
                new Movie(7, "Matrix", 136, Genre.ACTION)
        );
        Mockito.when(movieRepository.findAll()).thenReturn(allMovies);
        movieService = new MovieService(movieRepository);
    }

    @Test
    public void search_movie_by_genre() {

        movies = movieService.findMoviesByGenre(Genre.COMEDY);

        assertThat(getMovieIds(), is(Arrays.asList(3, 6)));

    }

    @Test
    public void search_movie_by_time() {

        movies = movieService.findMoviesByTime(119);

        assertThat(getMovieIds(), is(Arrays.asList(2, 3, 4, 5, 6)));

    }

    private List<Integer> getMovieIds() {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }

}
