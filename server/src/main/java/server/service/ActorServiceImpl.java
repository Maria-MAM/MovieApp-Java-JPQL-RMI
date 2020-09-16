package server.service;

import lib.dto.ActorDto;
import lib.service.ActorService;
import server.convert.ActorConvertor;
import server.dao.ActorDao;
import server.dao.impl.ActorDaoImpl;

import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.stream.Collectors;

public class ActorServiceImpl extends UnicastRemoteObject implements ActorService {

    private final ActorDao actorDao;

    public ActorServiceImpl() throws RemoteException {
        var emf = Persistence.createEntityManagerFactory("MovieAppPU");
        var em = emf.createEntityManager();
        actorDao = new ActorDaoImpl(em);
    }

    @Override
    public void persist(ActorDto actorDto) throws RemoteException {

        var actor = ActorConvertor.convert(actorDto);
        actorDao.persist(actor);
    }

    @Override
    public Collection<ActorDto> findAll() throws RemoteException {
        return actorDao.findAll().stream()
                .map(ActorConvertor::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<ActorDto> findByFilmId(int filmId) throws RemoteException {
        return actorDao.findByFilmId(filmId).stream()
                .map(ActorConvertor::convert)
                .collect(Collectors.toList());
    }
}
