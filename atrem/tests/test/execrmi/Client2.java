package test.execrmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import atrem.connect4.game.GameController;
import atrem.connect4.rmi.GameControllerService;
import atrem.connect4.rmi.RemoteGameController;
import atrem.connect4.rmi.RemotePlayerController;
import atrem.connect4.rmi.RemotePlayerControllerImp;

public class Client2 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {
		// tak ma byc pawel
		Registry registry = LocateRegistry.getRegistry(1234);

		RemoteGameController remoteGameController = (RemoteGameController) registry
				.lookup("gc");

		GameController gameControllerService = new GameControllerService(
				remoteGameController);
		RemotePlayerController remotePlayerController = new RemotePlayerControllerImp();
		remotePlayerController.createPlayer(gameControllerService);
		remoteGameController.addPlayerController(remotePlayerController);

	}
}
