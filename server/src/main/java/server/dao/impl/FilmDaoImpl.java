package server.dao.impl;

import server.model.Film;

import javax.persistence.EntityManager;
import java.util.Collection;

public class FilmDaoImpl implements server.dao.FilmDao {

    private final EntityManager entityManager;

    public FilmDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Film film) {
        entityManager.getTransaction().begin();
        entityManager.persist(film);
        entityManager.getTransaction().commit();
    }

    @Override
    public Collection<Film> findByActorId(int actorId) {
        var query = entityManager
                .createQuery("SELECT f FROM Film f JOIN f.actori a WHERE a.id = :id", Film.class);
        query.setParameter("id", actorId);
        return query.getResultList();
    }

    @Override
    public Collection<Film> findByRegizorId(int regizorId) {
        var query = entityManager
                .createQuery("SELECT f FROM Film f JOIN f.regizor r WHERE r.id = :id", Film.class);
        query.setParameter("id", regizorId);
        return query.getResultList();
    }

    @Override
    public Collection<Film> findAll() {
        var query = entityManager
                .createQuery("SELECT f FROM Film f", Film.class);
        return query.getResultList();
    }
}
