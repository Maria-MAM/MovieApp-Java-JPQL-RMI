package client.controller;

import lib.dto.FilmDto;
import lib.service.FilmService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Collection;

public class FilmController {

    private final FilmService filmService;

    private FilmController() {
        try {
            var registry = LocateRegistry.getRegistry("localhost", 6666);
            filmService = (FilmService) registry.lookup("filmService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static FilmController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void persist(FilmDto filmDto) {
        try {
            filmService.persist(filmDto);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Collection<FilmDto> findByActorId(int actorId) {
        try {
            return filmService.findByActorId(actorId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Collection<FilmDto> findByRegizorId(int regizorId) {
        try {
            return filmService.findByRegizorId(regizorId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Collection<FilmDto> findAll() {
        try {
            return filmService.findAll();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static final class SingletonHolder {
        public static final FilmController INSTANCE = new FilmController();
    }
}
