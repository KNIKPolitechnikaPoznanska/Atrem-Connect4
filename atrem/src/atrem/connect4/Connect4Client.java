package atrem.connect4;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import multiplayer.IConnect4Server;

public class Connect4Client {
	private static IConnect4Server connect4Server;

	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		Registry r = LocateRegistry.getRegistry(1234);
		connect4Server = (IConnect4Server) r.lookup("connect4Server");
	}
}
