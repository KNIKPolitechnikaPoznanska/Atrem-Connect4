package RMITest;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import atrem.connect4.game.GameController;

public class RemotePlayerControllerClient extends UnicastRemoteObject
		implements
			Remote {
	private GameController gameController;

	protected RemotePlayerControllerClient(GameController gameController)
			throws RemoteException {
		super();

		this.gameController = gameController;
	}

}
