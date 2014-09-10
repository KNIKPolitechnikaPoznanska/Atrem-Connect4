package atrem.connect4;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import RMITest.GameControllerService;
import RMITest.RemoteGameController;
import RMITest.RemotePlayerController;
import atrem.connect4.game.GameController;
import atrem.connect4.game.GameControllerImpl;

/**
 * Urruchamia serwer gry.
 */
public class Connect4Server {
	private static GameController gameController;
	private static RemoteGameController rGCS;
	private static RemoteGameController rGCC;
	private static RemotePlayerController rPCC, rPCS;

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

		rGCS = new GameControllerService(rGCC);

		registry.bind("RGCS", rGCS);

	}
}