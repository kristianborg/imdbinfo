package nl.krisborg.imdbinfo.util;

import nl.krisborg.imdbinfo.dto.Movie;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kris
 * @since 1-jan-2010
 */
public abstract class ImdbMovieHtmlConverter extends BaseConverter{

    private static final Pattern MOVIE_TITLE_PATTERN = Pattern.compile("<title>(.*?)</title>");
    private static final Pattern ACTOR_LIST_PATTERN = Pattern.compile("<table class=\"cast_list\">(.*?)</table>");
    private static final Pattern ACTOR_PATTERN = Pattern.compile("<tr class=(.*?)</tr>");
    private static final Pattern ACTOR_URL_PATTERN = Pattern.compile("href=\"(.*?)\"");
    private static final Pattern ACTOR_NAME_PATTERN = Pattern.compile("itemprop=\"name\">(.*?)</span>");

    private static final Log LOG = LogFactory.getLog(ImdbMovieHtmlConverter.class);

    public static Movie extractMovie(String html){
        html = html.replace('\r', ' ');
        html = html.replace('\n', ' ');

        Movie result = new Movie();
        String title = extractGroup(MOVIE_TITLE_PATTERN, html);
        result.setName(title);

        String actorListHtml = extractGroup(ACTOR_LIST_PATTERN, html);
        if (actorListHtml != null){

            Matcher actorMatcher = ACTOR_PATTERN.matcher(actorListHtml);
            int position = 0;
            int foundActors = 0;
            while (foundActors < MAX_CRAWL_LINKS && actorMatcher.find(position)){
                String actorHtml = actorMatcher.group(1);
                position = actorMatcher.end();
                String name = extractGroup(ACTOR_NAME_PATTERN, actorHtml);
                String url = extractGroup(ACTOR_URL_PATTERN, actorHtml);
                if (url != null){
                    result.getActors().add(IMDB_URL + removeRequestParameters(url));
                } else {
                    LOG.warn("Invalid actor list");
                }
                foundActors++;
            }
        }

        LOG.info("Created movie: " + result);

        return result;
    }

    private static String removeRequestParameters(String url){
        int pos = url.indexOf('?');
        if (pos > 0){
            return url.substring(0, pos);
        } else {
            return url;
        }
    }
}
