package atrem.connect4;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;
import atrem.connect4.rmi.GameControllerService;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.RemotePlayerController;
import atrem.connect4.rmi.RemotePlayerControllerImp;

/**
 * 
 */
public class Connect4Client {
	RemoteGameController remoteGameController;
	GameController gameControllerService;
	RemotePlayerController remotePlayerController;

	/**
	 * £aczy z serwerem.
	 * 
	 * @param adres
	 *            IP serwera
	 * @throws RemoteException
	 * @throws NotBoundException
	 */
	public void connect(String adress, int port) throws RemoteException,
			NotBoundException {
		Registry registry = LocateRegistry.getRegistry(adress, port);
		System.out.println("Nawi¹zywanie po³¹czenia z serwerem.   " + adress
				+ ":" + port);

		remoteGameController = (RemoteGameController) registry.lookup("RGC");
		gameControllerService = new GameControllerService(remoteGameController);
	}

	/**
	 * Tworzy zdalnych graczy PlayerController.
	 * 
	 * @param name
	 * @param color
	 * @throws RemoteException
	 */
	public void createPlayer(String name, Color color) throws RemoteException {
		remotePlayerController = new RemotePlayerControllerImp();
		remotePlayerController.createPlayer(gameControllerService, name, color);
		remoteGameController.addPlayerController(remotePlayerController);
		System.out.println("Gracz " + name + " dodany");
		remotePlayerController.opponentConnected();
	}
}