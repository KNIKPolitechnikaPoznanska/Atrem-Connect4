package RMITest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import atrem.connect4.game.player.PlayerController;

public class RemoteGameControllerClient extends UnicastRemoteObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PlayerController playerController;

	protected RemoteGameControllerClient(PlayerController playerController)
			throws RemoteException {
		super();
		this.playerController = playerController;
	}

}