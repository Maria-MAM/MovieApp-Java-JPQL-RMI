package server.dao.impl;

import server.model.Actor;

import javax.persistence.EntityManager;
import java.util.Collection;

public class ActorDaoImpl implements server.dao.ActorDao {

    private final EntityManager entityManager;

    public ActorDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void persist(Actor actor) {
        entityManager.getTransaction().begin();
        entityManager.persist(actor);
        entityManager.getTransaction().commit();
    }

    @Override
    public Collection<Actor> findAll() {
        var query = entityManager.createQuery("SELECT a FROM Actor a", Actor.class);
        return query.getResultList();
    }

    @Override
    public Collection<Actor> findByFilmId(int filmId) {
        var query =
                entityManager.createQuery("SELECT a FROM Actor a JOIN a.filme f WHERE f.id =:id",
                        Actor.class);
        query.setParameter("id", filmId);
        return query.getResultList();
    }

    @Override
    public Actor getById(int id) {

        return entityManager.find(Actor.class, id);

    }
}
