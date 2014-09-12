package atrem.connect4.rmi;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.swing.SwingPresenter;

public class RemotePlayerControllerImp extends UnicastRemoteObject
		implements
			RemotePlayerController {
	private PlayerAttributes playerAttributes;
	private PlayerController playerController;

	public RemotePlayerControllerImp() throws RemoteException {
		super();
	}

	@Override
	public void createPlayer(GameController gameControllerService, String name,
			Color color) {
		PlayerController playerID = gameControllerService.getPlayer1();
		if (playerID == null) {
			playerAttributes = new PlayerAttributes(name, PlayerId.PLAYER1, 0,
					color);
			playerController = new SwingPresenter(gameControllerService,
					playerAttributes, new Color(2, 2, 200), 0, false);
		} else {
			playerAttributes = new PlayerAttributes(name, PlayerId.PLAYER2, 0,
					color);
			playerController = new SwingPresenter(gameControllerService,
					playerAttributes, new Color(2, 2, 200), 0, false);
		}

	}

	@Override
	public void yourTurn() throws RemoteException {
		playerController.yourTurn();
	}

	@Override
	public void opponentConnected() throws RemoteException {
		playerController.opponentConnected();
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

	@Override
	public Color getColor() throws RemoteException {
		return playerController.getColor();
	}

	@Override
	public Color getOppColor() throws RemoteException {
		return playerController.getOppColor();
	}

	@Override
	public void setPlayerId(PlayerId playerId) throws RemoteException {
		playerController.setPlayerId(playerId);
	}
}
