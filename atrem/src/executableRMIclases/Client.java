package executableRMIclases;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import rmi.GameControllerService;
import rmi.RemoteGameController;
import rmi.RemotePlayerController;
import rmi.RemotePlayerControllerImp;
import atrem.connect4.game.GameController;
import atrem.connect4.game.player.PlayerAttributes;

public class Client {

	public Client(String name, Color color, String ip) throws RemoteException,
			NotBoundException, InterruptedException {

		PlayerAttributes playerAttributes = new PlayerAttributes(name, null, 0,
				color);
		Registry registry = LocateRegistry.getRegistry("localhost", 1234);

		RemoteGameController remoteGameController = (RemoteGameController) registry
				.lookup("gc");

		GameController gameControllerService = new GameControllerService(
				remoteGameController);
		RemotePlayerController remotePlayerController = new RemotePlayerControllerImp();
		if (remoteGameController.getPlayer1Attributes() == null) {
			remoteGameController.setPlayer1Attributes(playerAttributes);
		} else if (remoteGameController.getPlayer2Attributes() == null) {
			remoteGameController.setPlayer2Attributes(playerAttributes);
		}
		Scanner scaner = new Scanner(System.in);
		scaner.nextLine();
		// Thread.sleep(10000);
		remotePlayerController.createPlayer(gameControllerService,
				playerAttributes);
		remoteGameController.addPlayerController(remotePlayerController);

	}
}
