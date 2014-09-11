package test.tgame;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		GameServer server = new GameServerImpl();
		Registry registry = LocateRegistry.createRegistry(1234);
		registry.bind("server", server);

	}

}
