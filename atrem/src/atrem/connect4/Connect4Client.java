package atrem.connect4;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import multiplayer.IConnect4Server;
import atrem.connect4.factory.GameFactory;
import atrem.connect4.game.GameConfig;

public class Connect4Client {
	private static GameFactory gameFactory;
	private static GameConfig config;
	private IConnect4Server connect4Server;

	public Connect4Client() throws RemoteException, NotBoundException {
		gameFactory = new GameFactory();
		config = new GameConfig(gameFactory);

	}

	public void init() throws AccessException, RemoteException,
			NotBoundException {
		System.out.println("Klient odpalony.");
		config.showOnlineDBox();
		Registry r = LocateRegistry.getRegistry(1234);
		connect4Server = (IConnect4Server) r.lookup("connect4Server");
	}
}
