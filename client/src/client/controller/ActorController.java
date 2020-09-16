package client.controller;

import lib.dto.ActorDto;
import lib.service.ActorService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Collection;

public class ActorController {

    private final ActorService actorService;

    private ActorController() {
        try {
            var registry = LocateRegistry.getRegistry("localhost", 6666);
            actorService = (ActorService) registry.lookup("actorService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    ;

    public static ActorController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void persist(ActorDto actorDto) {
        try {
            actorService.persist(actorDto);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Collection<ActorDto> findByFilmId(int filmId) {
        try {
            return actorService.findByFilmId(filmId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Collection<ActorDto> findAll() {
        try {
            return actorService.findAll();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static final class SingletonHolder {
        public static final ActorController INSTANCE = new ActorController();
    }
}
