package movies.model;

import java.util.Objects;

/**
 *
 * @author Jesus Diaz
 */
public class Movie {

    private Integer id;
    private String name;
    private Integer minutes;
    private Genre genre;
    private String director;

    public Movie(String name, int minutes, Genre genre, String director) {
        this(null, name, minutes, genre, director); // Llama al constructor de abajo
    }

    public Movie(Integer id, String name, int minutes, Genre genre, String director) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
        this.director = director;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Usamos equals para comparar objetos
    // Usado en el test de la bd con jdbctemplate
    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre, director);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Movie other = (Movie) obj;

        return !(!Objects.equals(this.minutes, other.minutes)
                && !Objects.equals(this.name, other.name)
                && !Objects.equals(this.id, other.id)
                && this.genre != other.genre
                && !Objects.equals(this.director, other.director));
    }

}
