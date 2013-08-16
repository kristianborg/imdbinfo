package nl.krisborg.imdbinfo.services;

import nl.krisborg.imdbinfo.dto.Actor;

import javax.swing.*;
import java.util.List;
import java.util.Set;

/**
 * User: Kris
 * Since: 7-4-12 19:30
 */
public interface ActorService {

    public Number getNumActors();

    public Set<Actor> getActors();
}
