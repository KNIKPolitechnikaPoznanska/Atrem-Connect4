package testy.game.remote;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;
import atrem.connect4.game.GameControllerImpl;

public class Connect4RemoteServer {

	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		// TODO Auto-generated method stub
		// GameController Connect4 = new GameControllerImpl();
		// r.bind("Connect4", r);
		/**
		 * establish connection
		 */
		GameController gameController = new GameControllerImpl();
		RemoteGameController connect = new RemoteGameControllerImpl(
				gameController);

		Registry r = LocateRegistry.createRegistry(1234);

		r.bind("connect", connect);
		/**
 * 
 */
	}
}
