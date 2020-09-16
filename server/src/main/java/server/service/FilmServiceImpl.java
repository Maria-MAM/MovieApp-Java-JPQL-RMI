package server.service;

import lib.dto.FilmDto;
import lib.service.FilmService;
import server.convert.FilmConvertor;
import server.dao.ActorDao;
import server.dao.FilmDao;
import server.dao.RegizorDao;
import server.dao.impl.ActorDaoImpl;
import server.dao.impl.FilmDaoImpl;
import server.dao.impl.RegizorDaoImpl;

import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.stream.Collectors;

public class FilmServiceImpl extends UnicastRemoteObject implements FilmService {

    private final FilmDao filmDao;

    private final ActorDao actorDao;

    private final RegizorDao regizorDao;

    public FilmServiceImpl() throws RemoteException {
        var emf = Persistence.createEntityManagerFactory("MovieAppPU");
        var em = emf.createEntityManager();

        filmDao = new FilmDaoImpl(em);
        actorDao = new ActorDaoImpl(emf.createEntityManager());
        regizorDao = new RegizorDaoImpl(emf.createEntityManager());
    }

    @Override
    public void persist(FilmDto filmDto) throws RemoteException {
        var film = FilmConvertor.convert(filmDto);

        var actori = filmDto.getIdActori().stream()
                .map(actorDao::getById)
                .collect(Collectors.toSet());
        film.setActori(actori);

        var regizorId = filmDto.getIdRegizor();
        film.setRegizor(regizorDao.getById(regizorId));

        filmDao.persist(film);
    }

    @Override
    public Collection<FilmDto> findByActorId(int actorId) throws RemoteException {
        return filmDao.findByActorId(actorId).stream()
                .map(FilmConvertor::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<FilmDto> findByRegizorId(int regizorId) throws RemoteException {
        return filmDao.findByRegizorId(regizorId).stream()
                .map(FilmConvertor::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<FilmDto> findAll() throws RemoteException {
        return filmDao.findAll().stream()
                .map(FilmConvertor::convert)
                .collect(Collectors.toList());
    }
}
