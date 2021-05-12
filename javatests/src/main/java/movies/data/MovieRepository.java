
package movies.data;

import java.util.Collection;
import movies.model.Movie;

/**
 *
 * @author Jesus Diaz
 */
public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
}
