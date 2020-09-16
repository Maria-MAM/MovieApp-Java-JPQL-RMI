package lib.service;

import lib.dto.RegizorDto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface RegizorService extends Remote {

    void persist(RegizorDto regizorDto) throws RemoteException;

    Collection<RegizorDto> findAll() throws RemoteException;

    RegizorDto findByFilmId(int filmId) throws RemoteException;
}
