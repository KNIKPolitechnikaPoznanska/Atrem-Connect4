package testy.game.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;

public class Player1 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {
		// TODO Auto-generated method stub

		// GameController Connect4 = (GameController) r.lookup("connect");
		// LocalPlayerController player = new LocalPlayerControlerImpl();
		/**
		 * connect
		 */

		RemotePlayerController player = new RemotePlayerControlerImpl();
		Registry r = LocateRegistry.getRegistry(1234);
		RemoteGameController connect = (RemoteGameController) r
				.lookup("connect");
		GameController gameController = new LocalGameController(connect);
		connect.addPlayer(player);
		player.createPlayer(gameController);

	}
}
