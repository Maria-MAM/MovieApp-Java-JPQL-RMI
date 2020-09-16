package lib.service;

import lib.dto.ActorDto;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface ActorService extends Remote {

    void persist(ActorDto actorDto) throws RemoteException;

    Collection<ActorDto> findAll() throws RemoteException;

    Collection<ActorDto> findByFilmId(int filmId) throws RemoteException;

}
