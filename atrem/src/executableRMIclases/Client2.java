package executableRMIclases;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.GameControllerService;
import rmi.RemoteGameController;
import rmi.RemotePlayerController;
import rmi.RemotePlayerControllerImp;
import atrem.connect4.game.GameController;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerId;

public class Client2 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {
		// tak ma byc pawel
		PlayerAttributes playerAttributes = new PlayerAttributes("pawel",
				PlayerId.PLAYER1, 0, new Color(25, 25, 25));
		Registry registry = LocateRegistry.getRegistry(80);

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
		Thread.sleep(10000);
		remotePlayerController.createPlayer(gameControllerService);
		remoteGameController.addPlayerController(remotePlayerController);

	}
}
