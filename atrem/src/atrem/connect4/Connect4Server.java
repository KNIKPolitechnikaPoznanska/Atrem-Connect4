package atrem.connect4;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMITest.RemoteGameController;
import RMITest.RemoteGameControllerServer;
import atrem.connect4.game.GameController;
import atrem.connect4.game.GameControllerImpl;

/**
 * Urruchamia serwer gry.
 */
public class Connect4Server {
	private static RemoteGameController remoteGameController;
	private static GameController gameController;

	/**
	 * Uruchamia tylko serwer.
	 * 
	 * @param args
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 */
	public static void main(String[] args) throws RemoteException,
			AlreadyBoundException {
		Registry registry = LocateRegistry.createRegistry(1234);

		gameController = new GameControllerImpl();
		remoteGameController = new RemoteGameControllerServer();

		registry.bind("RGCS", remoteGameController);

	}
}