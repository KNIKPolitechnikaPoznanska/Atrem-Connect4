package executableRMIclases;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmi.GameControllerService;
import rmi.RemoteGameController;
import rmi.RemotePlayerController;
import rmi.RemotePlayerControllerImp;
import atrem.connect4.game.GameController;

public class Client2 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {
		// tak ma byc pawel
		Registry registry = LocateRegistry.getRegistry(80);

		RemoteGameController remoteGameController = (RemoteGameController) registry
				.lookup("gc");

		GameController gameControllerService = new GameControllerService(
				remoteGameController);
		RemotePlayerController remotePlayerController = new RemotePlayerControllerImp();
		remoteGameController.addPlayerController(remotePlayerController);
		remotePlayerController.createPlayer(gameControllerService);

	}
}
