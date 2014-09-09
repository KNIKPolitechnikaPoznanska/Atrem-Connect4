package atrem.connect4;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import multiplayer.IConnect4Server;
import atrem.connect4.console.Menu;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameFactory;

public class Connect4Client {
	private static GameFactory gameFactory;
	private static GameConfig config;
	private static Menu menu;
	private IConnect4Server connect4Server;

	public Connect4Client() throws RemoteException, NotBoundException {

		gameFactory = new GameFactory();
		config = new GameConfig(gameFactory);
	}

	public void runOnLocal() throws RemoteException, NotBoundException {
		System.out.println("Lokalny Klient na LocalServer odpalony.");
		config.showClientDBox();
		Registry r = LocateRegistry.getRegistry(1234);
		connect4Server = (IConnect4Server) r.lookup("connect4LocalServer");
	}

	public void runOnServer() throws AccessException, RemoteException,
			NotBoundException {
		System.out.println("Lokalny Klient na RemoteServer odpalony.");
		config.showServerDBox();
		Registry r = LocateRegistry.getRegistry(1234);
		connect4Server = (IConnect4Server) r.lookup("connect4Server");
	}
}
