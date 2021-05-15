package movies.data;

import java.sql.SQLException;
import java.sql.Statement;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import movies.model.*;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

/**
 *
 * @author Jesus Diaz
 */
public class MovieRepositoryJdbcTest {

    // Crear una base de datos en memoria de pruebas usando h2database en el pom
    private static final String MODE = "MODE=MYSQL";
    private static final String BD = "test";
    private static final String URL = "jdbc:h2:mem:" + MovieRepositoryJdbcTest.BD + ";" + MovieRepositoryJdbcTest.MODE;
    private static final String USER = "sa";
    private static final String PASSWORD = "sa";
    private static final String PATH = "sqlscripts/BDMovie.sql";
    private DriverManagerDataSource dataSource;
    private MovieRepositoryJdbc movieRepository;
    private List<Movie> allMovies;

    @Before
    public void setup() throws SQLException {

        // Nos conectamos a la base de datos en memoria
        dataSource = new DriverManagerDataSource(MovieRepositoryJdbcTest.URL,
                MovieRepositoryJdbcTest.USER,
                MovieRepositoryJdbcTest.PASSWORD);

        // Ejecuto el script para crear la tabla de Movies y sus registros
        ScriptUtils.executeSqlScript(dataSource.getConnection(),
                new ClassPathResource(MovieRepositoryJdbcTest.PATH));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        movieRepository = new MovieRepositoryJdbc(jdbcTemplate);

        allMovies = Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION, "Christopher Nolan"),
                new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan"),
                new Movie(3, "Matrix", 136, Genre.ACTION, "Lilly Wachowski")
        );
    }

    @Test
    public void test_load_all_movies() {
        Collection<Movie> movies = movieRepository.findAll();
        assertThat(movies, is(allMovies));
    }

    @Test
    public void test_load_movie_by_id() {
        Movie movie = movieRepository.findById(2);
        assertThat(movie, is(new Movie(2, "Memento", 113, Genre.THRILLER, "Christopher Nolan")));
    }

    @Test
    public void test_inset_a_movie() {
        Movie movie = new Movie("Super 8", 112, Genre.THRILLER, "Jeffrey Jacob Abrams");
        movieRepository.saveOrUpdate(movie);

        Movie movieFromDB = movieRepository.findById(4);

        assertThat(movieFromDB, is(new Movie(4, "Super 8", 112, Genre.THRILLER, "Jeffrey Jacob Abrams")));
    }

    @After
    public void tearDown() throws Exception {
        // Borramos todos los datos de la base de datos
        final Statement s = dataSource.getConnection().createStatement();
        String query = "DROP ALL OBJECTS DELETE FILES";
        s.execute(query);
    }

}
