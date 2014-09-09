package testy.game;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client1 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {
		Registry r = LocateRegistry.getRegistry(1234);
		GameServer server = (GameServer) r.lookup("server");

		PlayerInterface player = new PlayerImpl();

		server.setPlayer(0, player);
		Thread.sleep(10000);
		PlayerInterface player2 = server.getPlayer(1);
		System.out.println("Mam playera nr 2");
		Thread.sleep(10000);
		player2.makeMove("twój ruch");

	}

}
