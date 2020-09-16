package server.dao;

import server.model.Actor;

import java.util.Collection;

public interface ActorDao {
    void persist(Actor actor);

    Collection<Actor> findAll();

    Collection<Actor> findByFilmId(int filmId);

    Actor getById(int id);
}
