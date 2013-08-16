package nl.krisborg.imdbinfo.util;

import nl.krisborg.imdbinfo.dto.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Kris
 * @since 1-jan-2010
 */
@ContextConfiguration(locations = {"classpath:data-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImdbMovieHtmlConverterTest extends BaseConverterTest {

    public static final String MOVIE_FILE = "src/test/resources/movie_titanic.htm";
    public static final int MOVIE_NUM_ACTORS = 15;
    public static final String MOVIE_TITLE = "Titanic (1997) - IMDb";
    public static final String MOVIE_EXAMPLE_ACTOR_URL = "http://www.imdb.com/name/nm0000138/";

    @Test
    public void testMovie() throws IOException {
        String html = getFileAsString(MOVIE_FILE);
        Movie movie = ImdbMovieHtmlConverter.extractMovie(html);
        assertNotNull(movie);
        assertEquals(MOVIE_TITLE, movie.getName());

        Set<String> actors = movie.getActors();
        assertEquals(MOVIE_NUM_ACTORS, actors.size());
        assertTrue(actors.contains(MOVIE_EXAMPLE_ACTOR_URL));
    }
}
