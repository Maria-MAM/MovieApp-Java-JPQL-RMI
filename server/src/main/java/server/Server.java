package server;

import server.service.ActorServiceImpl;
import server.service.FilmServiceImpl;
import server.service.RegizorServiceImpl;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) throws RemoteException {

        var registry = LocateRegistry.createRegistry(6666);

        registry.rebind("actorService", new ActorServiceImpl());
        registry.rebind("regizorService", new RegizorServiceImpl());
        registry.rebind("filmService", new FilmServiceImpl());
    }
}
