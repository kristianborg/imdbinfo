package nl.krisborg.imdbinfo.dao;


import nl.krisborg.imdbinfo.dto.Movie;

import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Kris
 * Date: 31-dec-2009
 * Time: 13:12:57
 * To change this template use File | Settings | File Templates.
 */
public interface MovieDao {

    public Number getNumMovies();

    public void saveOrUpdate(Movie movie);

    Set<Movie> retrieveAllMoviesFromDatabase();

    Movie getMovieByUrl(String url);
}
