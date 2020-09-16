package client.controller;

import lib.dto.RegizorDto;
import lib.service.RegizorService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Collection;

public class RegizorController {

    private final RegizorService regizorService;

    private RegizorController() {
        try {
            var registry = LocateRegistry.getRegistry("localhost", 6666);
            regizorService = (RegizorService) registry.lookup("regizorService");
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }

    ;

    public static RegizorController getInstance() {
        return RegizorController.SingletonHolder.INSTANCE;
    }

    public void persist(RegizorDto regizorDto) {
        try {
            regizorService.persist(regizorDto);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Collection<RegizorDto> findAll() {
        try {
            return regizorService.findAll();
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public RegizorDto findByFilmId(int filmId) {
        try {
            return regizorService.findByFilmId(filmId);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private static final class SingletonHolder {
        public static final RegizorController INSTANCE = new RegizorController();
    }
}
