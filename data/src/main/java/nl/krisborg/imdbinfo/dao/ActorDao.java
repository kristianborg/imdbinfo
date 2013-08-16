package nl.krisborg.imdbinfo.dao;

import nl.krisborg.imdbinfo.dto.Actor;

import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: Kris
 * Date: 31-dec-2009
 * Time: 13:16:22
 * To change this template use File | Settings | File Templates.
 */
public interface ActorDao {

    public Number getNumActors();

    public void saveOrUpdate(Actor actor);

    Set<Actor> getActors();

    Actor getActorByUrl(String url);
}
