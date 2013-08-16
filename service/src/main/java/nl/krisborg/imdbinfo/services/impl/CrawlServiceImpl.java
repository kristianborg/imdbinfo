package nl.krisborg.imdbinfo.services.impl;

import nl.krisborg.imdbinfo.util.ImdbActorHtmlConverter;
import nl.krisborg.imdbinfo.util.ImdbMovieHtmlConverter;
import nl.krisborg.imdbinfo.dao.ActorDao;
import nl.krisborg.imdbinfo.dao.ImdbSiteDao;
import nl.krisborg.imdbinfo.dao.MovieDao;
import nl.krisborg.imdbinfo.dto.Actor;
import nl.krisborg.imdbinfo.dto.Movie;
import nl.krisborg.imdbinfo.services.CrawlService;
import nl.krisborg.imdbinfo.util.ImdbUrlHelper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: Kris
 * Since: 7-4-12 20:05
 */
public class CrawlServiceImpl implements CrawlService {

    @Autowired
    private MovieDao movieDao;

    @Autowired
    private ActorDao actorDao;

    @Autowired
    private ImdbSiteDao imdbDao;
    
    public void crawlUrl(String url, int crawlDepth) {
        if (ImdbUrlHelper.isMovieUrl(url)){
            crawlMovie(url, crawlDepth);
        } else if (ImdbUrlHelper.isActorUrl(url)){
            crawlActor(url, crawlDepth);
        } else {
            throw new RuntimeException("Unexpected imdb url format");
        }
    }

    private void crawlMovie(String url, int crawlDepth){
        Movie movie = movieDao.getMovieByUrl(url);
        if (movie == null){
            String html = imdbDao.getHtmlFile(url);
            movie = ImdbMovieHtmlConverter.extractMovie(html);
            movie.setUrl(url);
            movieDao.saveOrUpdate(movie);
        }

        if (crawlDepth > 1){
            for(String actor : movie.getActors()){
                crawlActor(actor, crawlDepth - 1);
            }
        }
    }

    private void crawlActor(String url, int crawlDepth){
        Actor actor = actorDao.getActorByUrl(url);
        if (actor == null){
            String html = imdbDao.getHtmlFile(url);
            actor = ImdbActorHtmlConverter.extractActor(html);
            actor.setUrl(url);
            actorDao.saveOrUpdate(actor);
        }

        if (crawlDepth > 1){
            for(String movie : actor.getMovies()){
                crawlMovie(movie, crawlDepth - 1);
            }
        }
    }
}
