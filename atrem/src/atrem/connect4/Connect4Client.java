package atrem.connect4;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.RemotePlayerController;
import atrem.connect4.rmi.client.GameControllerClient;
import atrem.connect4.rmi.server.PlayerControllerService;

public class Connect4Client {
	private RemoteGameController gameCService;

	private GameController gameController;
	private RemotePlayerController playerCService;
	private PlayerController playerController;

	/**
	 * £aczy z serwerem.
	 * 
	 * @param adres
	 *            IP serwera
	 */
	public void connect(String adress) {
		try {
			Registry registry = LocateRegistry.getRegistry(adress, 1234);
			System.out.println("Nawi¹zywanie po³¹czenia z serwerem.");

			playerCService = new PlayerControllerService();

			gameCService = (RemoteGameController) registry.lookup("RGCS");
			gameController = new GameControllerClient(gameCService);
		} catch (RemoteException | NotBoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}

	/**
	 * Tworzy zdalnych graczy PlayerController
	 * 
	 * @param name
	 * @param color
	 */
	public void createPlayer(String name, Color color) {
		try {
			gameCService.addRemotePlayer(playerCService);
			playerCService.createPlayer(gameController, name, color);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
