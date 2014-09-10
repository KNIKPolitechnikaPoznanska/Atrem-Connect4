package RMITest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public class PlayerControllerClient extends UnicastRemoteObject
		implements
			RemotePlayerController {
	private PlayerController playerController;

	public PlayerControllerClient(PlayerController playerController)
			throws RemoteException {
		super();
		this.playerController = playerController;
	}

	@Override
	public void setName(String playerName) throws RemoteException {
		playerController.setName(playerName);

	}

	@Override
	public PlayerId getPlayerId() throws RemoteException {
		return playerController.getPlayerId();

	}

	@Override
	public void yourTurn() throws RemoteException {
		playerController.yourTurn();

	}

	@Override
	public void setGamecontroller(GameController gamecontroller)
			throws RemoteException {
		playerController.setGamecontroller(gamecontroller);

	}

	@Override
	public void endOfGame(ResultState resultGame) throws RemoteException {
		playerController.endOfGame(resultGame);

	}

	@Override
	public int getPlayerPoints() throws RemoteException {
		return playerController.getPlayerPoints();
	}

	@Override
	public PlayerAttributes getPlayerAttributes() throws RemoteException {
		return playerController.getPlayerAttributes();
	}

	@Override
	public String getName() throws RemoteException {

		return playerController.getName();
	}
}
