package lib.service;

import lib.dto.FilmDto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface FilmService extends Remote {

    void persist(FilmDto filmDto) throws RemoteException;

    Collection<FilmDto> findByActorId(int actorId) throws RemoteException;

    Collection<FilmDto> findByRegizorId(int regizorId) throws RemoteException;

    Collection<FilmDto> findAll() throws RemoteException;
}
