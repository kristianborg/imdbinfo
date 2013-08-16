package nl.krisborg.imdbinfo.services.impl;

import nl.krisborg.imdbinfo.dao.ActorDao;
import nl.krisborg.imdbinfo.dto.Actor;
import nl.krisborg.imdbinfo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Kris
 * Since: 7-4-12 19:31
 */
public class ActorServiceImpl implements ActorService {

    @Autowired
    ActorDao dao;

    public Number getNumActors() {
        return dao.getNumActors();
    }

    public Set<Actor> getActors(){
        return dao.getActors();
    }
}
