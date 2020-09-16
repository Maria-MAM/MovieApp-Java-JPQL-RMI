package server.dao;

import server.model.Regizor;

import java.util.Collection;

public interface RegizorDao {
    void persist(Regizor regizor);

    Collection<Regizor> findAll();

    Regizor findByFilmId(int filmId);

    Regizor getById(int id);
}
