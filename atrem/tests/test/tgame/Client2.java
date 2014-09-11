package test.tgame;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client2 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException {
		Registry r = LocateRegistry.getRegistry(1234);
		GameServer server = (GameServer) r.lookup("server");

		PlayerInterface player = new PlayerImpl();

		server.setPlayer(1, player);

	}

}
