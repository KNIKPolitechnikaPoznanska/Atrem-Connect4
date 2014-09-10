package executableRMIclases;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.GameControllerService;
import rmi.RemoteGameController;
import atrem.connect4.game.GameController;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.swing.SwingPresenter;

public class Client {
	static RemoteGameController remoteGameController;
	static PlayerAttributes playerAttributes1 = new PlayerAttributes("pawel",
			PlayerId.PLAYER1, 0, new Color(2, 2, 200));
	static PlayerController player;

	public static void main(String[] args) throws RemoteException {

		Registry registry = LocateRegistry.getRegistry("localhost", 6969);
		try {
			RemoteGameController remoteGameController = (RemoteGameController) registry
					.lookup("GC");
		} catch (NotBoundException e) {
			System.out.println("wyjatek klienta");
		}

		GameController gameControllerService = new GameControllerService(
				remoteGameController);
		player = new SwingPresenter(gameControllerService, playerAttributes1,
				new Color(100, 100, 100), 0);
	}
}
