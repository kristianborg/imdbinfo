package nl.krisborg.imdbinfo.dao;

import nl.krisborg.imdbinfo.dto.Movie;
import org.hibernate.Criteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Kris
 * @since 13-feb-2010
 */
@Transactional
public class MovieDaoImpl extends AbstractBaseDao implements MovieDao {

    public Number getNumMovies(){
        return (Number) getSessionFactory().getCurrentSession().createCriteria(Movie.class)
                .setProjection(Projections.rowCount()).uniqueResult();

    }

    public void saveOrUpdate(Movie movie) {
        sessionFactory.getCurrentSession().saveOrUpdate(movie);
    }

    public Set<Movie> retrieveAllMoviesFromDatabase() {
        Criteria criteria = getSessionFactory().getCurrentSession()
                .createCriteria(Movie.class);
        return new HashSet<Movie>(criteria.list());
    }

    public Movie getMovieByUrl(String url) {
        Criteria criteria = getSessionFactory().getCurrentSession()
                .createCriteria(Movie.class);
        criteria.add(Restrictions.eq("url", url));
        return (Movie)criteria.uniqueResult();
    }
}
