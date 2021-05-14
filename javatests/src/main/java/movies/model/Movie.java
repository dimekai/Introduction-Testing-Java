package movies.model;

import java.util.Objects;

/**
 *
 * @author Jesus Diaz
 */
public class Movie {

    private Integer id;
    private String name;
    private int minutes;
    private Genre genre;

    public Movie(String name, int minutes, Genre genre) {
        this(null, name, minutes, genre); // Llama al constructor de abajo
    }

    public Movie(Integer id, String name, int minutes, Genre genre) {
        this.id = id;
        this.name = name;
        this.minutes = minutes;
        this.genre = genre;
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

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    // Usamos equals para comparar objetos
    // Usado en el test de la bd con jdbctemplate
    @Override
    public int hashCode() {
        return Objects.hash(id, name, minutes, genre);
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

        return !(this.minutes != other.minutes
                && !Objects.equals(this.name, other.name)
                && !Objects.equals(this.id, other.id)
                && this.genre != other.genre);
    }

}
