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

	private PlayerController player;
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
		this.player = new SwingPresenter(gameController, playerAttributes,
				color.darker(), 0);
	}

	@Override
	public String getName() throws RemoteException {
		return player.getName();
	}

	@Override
	public void setName(String playerName) throws RemoteException {
		player.setName(playerName);

	}

	@Override
	public PlayerId getPlayerId() throws RemoteException {
		return player.getPlayerId();
	}

	@Override
	public void yourTurn() throws RemoteException {
		player.yourTurn();

	}

	@Override
	public void setGamecontroller(GameController gamecontroller)
			throws RemoteException {
		player.setGamecontroller(gamecontroller);

	}

	@Override
	public void endOfGame(ResultState resultGame) throws RemoteException {
		player.endOfGame(resultGame);

	}

	@Override
	public int getPlayerPoints() throws RemoteException {
		return player.getPlayerPoints();

	}

	@Override
	public PlayerAttributes getPlayerAttributes() throws RemoteException {
		return player.getPlayerAttributes();
	}
}
