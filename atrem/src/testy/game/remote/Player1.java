package testy.game.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Player1 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {
		// TODO Auto-generated method stub

		// GameController Connect4 = (GameController) r.lookup("connect");
		// LocalPlayerController player = new LocalPlayerControlerImpl();
		/**
		 * connect
		 */
		Registry r = LocateRegistry.getRegistry("locahost", 1254);
		RemotePlayerController connect = (RemotePlayerController) r
				.lookup("connect");
		/**
		 * 
		 */

		LocalGameController gameController = new LocalGameController();

	}

}
