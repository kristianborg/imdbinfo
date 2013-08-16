package nl.krisborg.imdbinfo.util;

/**
 * User: Kris
 * Since: 8-4-12 14:13
 */
public abstract class ImdbUrlHelper {

    public static boolean isMovieUrl(String url){
        return url.indexOf("http://www.imdb.com/title/tt") != -1;
    }

    public static boolean isActorUrl(String url){
        return url.indexOf("http://www.imdb.com/name/nm") != -1;
    }
}
