package atrem.connect4;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import multiplayer.GameServer;
import multiplayer.IConnect4Server;

/**
 * Urruchamia serwer gry.
 */
public class Connect4Server {
	private static IConnect4Server connect4Server;

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		connect4Server = new GameServer();
		Registry registry = LocateRegistry.createRegistry(1234);
		registry.bind("connect4Server", connect4Server);
	}
}
