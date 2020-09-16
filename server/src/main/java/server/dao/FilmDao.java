package server.dao;

import server.model.Film;

import java.util.Collection;

public interface FilmDao {
    void persist(Film film);

    Collection<Film> findByActorId(int actorId);

    Collection<Film> findByRegizorId(int regizorId);

    Collection<Film> findAll();
}
