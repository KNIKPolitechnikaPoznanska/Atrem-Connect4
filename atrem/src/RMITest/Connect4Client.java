package RMITest;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.RemotePlayerController;
import atrem.connect4.rmi.client.GameControllerSender;
import atrem.connect4.rmi.client.PlayerControllerService;

/**
 * 
 */
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

			this.playerCService = new PlayerControllerService();

			this.gameCService = (RemoteGameController) registry.lookup("RGCS");
			this.gameController = new GameControllerSender(gameCService);
		} catch (RemoteException | NotBoundException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}
	}

	/**
	 * Tworzy zdalnych graczy PlayerController.
	 * 
	 * @param name
	 * @param color
	 */
	public void createPlayer(String name, Color color) {
		try {
			playerCService.createPlayer(gameController, name, color);
			gameCService.addRemotePlayer(playerCService);
			System.out.println("Gracz dodany");
		} catch (RemoteException e) {
			System.out.println("Problem z przypisaniem gracza.");
			e.printStackTrace();
		}
	}

	public void startGame() throws RemoteException {
		PlayerController playerOne;
		if (gameCService.getPlayer1() == null)
			playerController = gameCService.getPlayer1();
		else {
			playerOne = gameCService.getPlayer1();
			playerController = gameCService.getPlayer2();
			playerOne.yourTurn();
		}
	}
}