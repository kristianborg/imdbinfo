package nl.krisborg.imdbinfo.util;

import nl.krisborg.imdbinfo.dto.Actor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Kris
 * @since 2-jan-2010
 */
public abstract class ImdbActorHtmlConverter  extends BaseConverter{

    private static final Log LOG = LogFactory.getLog(ImdbActorHtmlConverter.class);

    private static final Pattern ACTOR_NAME_PATTERN = Pattern.compile("<title>(.*?)</title>");
    private static final Pattern MOVIE_LIST_PATTERN = Pattern.compile("<div id=\"filmo-head-Act(.*?)<div id=\"filmo-head-");
    private static final Pattern MOVIE_PATTERN = Pattern.compile("<div class=(.*?)</div>");
    private static final Pattern MOVIE_URL_PATTERN = Pattern.compile("href=\"(.*?)\"");
    private static final Pattern MOVIE_TITLE_PATTERN = Pattern.compile("<a.*?>(.*?)</a>");

    public static Actor extractActor(String html){
        html = html.replace('\r', ' ');
        html = html.replace('\n', ' ');

        Actor result = new Actor();
        String name = extractGroup(ACTOR_NAME_PATTERN, html);
        result.setName(name);

        String actorListHtml = extractGroup(MOVIE_LIST_PATTERN, html);
        if (actorListHtml != null){

            Matcher actorMatcher = MOVIE_PATTERN.matcher(actorListHtml);
            int position = 0;
            int foudMovies = 0;
            while (foudMovies < MAX_CRAWL_LINKS && actorMatcher.find(position)){
                String actorHtml = actorMatcher.group(1);
                position = actorMatcher.end();
                String title = extractGroup(MOVIE_TITLE_PATTERN, actorHtml);
                String url = extractGroup(MOVIE_URL_PATTERN, actorHtml);
                if (url != null){
                    result.getMovies().add(IMDB_URL + url);
                } else {
                    LOG.warn("Invalid movie list");
                }
                foudMovies++;
            }
        }

        LOG.info("Created actor: " + result);

        return result;
    }
}
