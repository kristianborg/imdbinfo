package nl.krisborg.imdbinfo.services.impl;

import nl.krisborg.imdbinfo.dao.MovieDao;
import nl.krisborg.imdbinfo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: Kris
 * Since: 7-4-12 17:39
 */
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieDao dao;

    public Number getNumMovies() {
        return dao.getNumMovies();
    }
}
