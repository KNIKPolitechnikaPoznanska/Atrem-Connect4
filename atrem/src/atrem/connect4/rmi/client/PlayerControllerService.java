package atrem.connect4.rmi.client;

import java.awt.Color;
import java.io.Serializable;
import java.rmi.RemoteException;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.rmi.RemotePlayerController;
import atrem.connect4.swing.SwingPresenter;

public class PlayerControllerService
		implements
			RemotePlayerController,
			Serializable {

	private PlayerController playerController;
	private PlayerAttributes playerAttributes;

	public PlayerControllerService() throws RemoteException {
		super();
	}

	@Override
	public void createPlayer(GameController gameController, String name,
			Color color) {
		if (gameController.getPlayer1() == null) {
			playerAttributes = new PlayerAttributes(name, PlayerId.PLAYER1, 0,
					color);
			gameController.setPlayer1Attributes(playerAttributes);
		} else {
			playerAttributes = new PlayerAttributes(name, PlayerId.PLAYER2, 0,
					color);
			gameController.setPlayer2Attributes(playerAttributes);
		}
		this.playerController = new SwingPresenter(gameController, playerAttributes,
				color.darker(), 0);
	}

	@Override
	public String getName() throws RemoteException {
		return playerController.getName();
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
}
