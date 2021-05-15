package movies.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import movies.model.Genre;
import movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MovieRepositoryJdbc implements MovieRepository {

    private JdbcTemplate jdbcTemplates;

    public MovieRepositoryJdbc(JdbcTemplate jdbcTemplates) {
        this.jdbcTemplates = jdbcTemplates;
    }

    @Override
    public Movie findById(long id) {
        Object[] args = {id};
        // queryForObject: Nos devuelve un solo objeto
        return jdbcTemplates.queryForObject("SELECT * FROM Movies WHERE ID = ?", args, movieMapper);
    }

    @Override
    public Collection<Movie> findAll() {
        // query: Nos devuelve una coleccion de objetos
        return jdbcTemplates.query("SELECT * FROM Movies", movieMapper);
    }

    private static RowMapper<Movie> movieMapper = new RowMapper<Movie>() {
        @Override
        public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Movie(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("minutes"),
                    Genre.valueOf(rs.getString("genre")),
                    rs.getString("director")
            );
        }
    };

    @Override
    public void saveOrUpdate(Movie movie) {
        jdbcTemplates.update("INSERT INTO Movies (NAME, MINUTES, GENRE, DIRECTOR) VALUES (?, ?, ?, ?)",
                movie.getName(),
                movie.getMinutes(),
                movie.getGenre().toString(),
                movie.getDirector()
        );
    }

}
