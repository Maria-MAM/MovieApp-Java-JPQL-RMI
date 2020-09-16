package server.dao.impl;

import server.model.Regizor;

import javax.persistence.EntityManager;
import java.util.Collection;

public class RegizorDaoImpl implements server.dao.RegizorDao {

    private final EntityManager entityManager;

    public RegizorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Regizor regizor) {
        entityManager.getTransaction().begin();
        entityManager.persist(regizor);
        entityManager.getTransaction().commit();
    }

    @Override
    public Collection<Regizor> findAll() {
        var query = entityManager.createQuery("SELECT r FROM Regizor r", Regizor.class);
        return query.getResultList();
    }

    @Override
    public Regizor findByFilmId(int filmId) {
        var query = entityManager
                .createQuery("SELECT r FROM Regizor r JOIN Film f ON " +
                                "r.id=f.regizor.id WHERE f.id = :id",
                        Regizor.class);
        query.setParameter("id", filmId);
        return query.getSingleResult();
    }

    @Override
    public Regizor getById(int id) {

        return entityManager.find(Regizor.class, id);

    }
}
