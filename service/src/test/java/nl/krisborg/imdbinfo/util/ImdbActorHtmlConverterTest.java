package nl.krisborg.imdbinfo.util;

import junit.framework.Assert;
import nl.krisborg.imdbinfo.dto.Actor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Set;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author Kris
 * @since 2-jan-2010
 */
@ContextConfiguration(locations = {"classpath:data-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ImdbActorHtmlConverterTest  extends BaseConverterTest {

    public static final String ACTOR_FILE = "src/test/resources/actor_angelina_jolie.htm";
    public static final String ACTOR_NAME = "Angelina Jolie - IMDb";
    public static final int ACTOR_NUM_MOVIES = 45;
    public static final String ACTOR_EXAMPLE_MOVIE_URL = "http://www.imdb.com/title/tt0493464/";

    public static final String MALE_ACTOR_FILE = "src/test/resources/actor_brad_pitt.htm";

    @Test
    public void testFemaleActor() throws IOException {
        String html = getFileAsString(ACTOR_FILE);
        Actor actor = ImdbActorHtmlConverter.extractActor(html);
        assertNotNull(actor);
        Assert.assertEquals(ACTOR_NAME, actor.getName());

        Set<String> movies = actor.getMovies();
        Assert.assertEquals(ACTOR_NUM_MOVIES, movies.size());
        assertTrue(movies.contains(ACTOR_EXAMPLE_MOVIE_URL));
    }

    @Test
    public void testMaleActor() throws IOException {
        String html = getFileAsString(MALE_ACTOR_FILE);
        Actor actor = ImdbActorHtmlConverter.extractActor(html);
        assertNotNull(actor);
        assertNotNull(actor.getName());
        assertFalse(actor.getMovies().isEmpty());
    }
}
