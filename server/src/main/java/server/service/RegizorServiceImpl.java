package server.service;

import lib.dto.RegizorDto;
import lib.service.RegizorService;
import server.convert.RegizorConvertor;
import server.dao.RegizorDao;
import server.dao.impl.RegizorDaoImpl;

import javax.persistence.Persistence;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.stream.Collectors;

public class RegizorServiceImpl extends UnicastRemoteObject implements RegizorService {

    private final RegizorDao regizorDao;

    public RegizorServiceImpl() throws RemoteException {
        var emf = Persistence.createEntityManagerFactory("MovieAppPU");
        var em = emf.createEntityManager();
        regizorDao = new RegizorDaoImpl(em);
    }

    @Override
    public void persist(RegizorDto regizorDto) throws RemoteException {

        var regizor = RegizorConvertor.convert(regizorDto);
        regizorDao.persist(regizor);
    }

    @Override
    public Collection<RegizorDto> findAll() throws RemoteException {
        return regizorDao.findAll().stream()
                .map(RegizorConvertor::convert)
                .collect(Collectors.toList());
    }

    @Override
    public RegizorDto findByFilmId(int filmId) throws RemoteException {
        return RegizorConvertor.convert(regizorDao.findByFilmId(filmId));
    }
}
