package nl.krisborg.imdbinfo.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Kris
 * Since: 8-4-12 15:44
 */
public abstract class BaseConverter {

    protected static final String IMDB_URL = "http://www.imdb.com";
    protected static final int MAX_CRAWL_LINKS = 100;

    protected static String extractGroup(Pattern pattern, String input){
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()){
            return matcher.group(1);
        } else {
            return null;
        }
    }
}
