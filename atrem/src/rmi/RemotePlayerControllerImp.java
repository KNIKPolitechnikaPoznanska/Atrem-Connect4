package rmi;

import java.awt.Color;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.swing.SwingPresenter;

public class RemotePlayerControllerImp extends UnicastRemoteObject implements
		RemotePlayerController {
	private PlayerAttributes playerAttributes1 = new PlayerAttributes("wojtek",
			PlayerId.PLAYER1, 0, new Color(100, 100, 100));

	private PlayerController playerController;

	public RemotePlayerControllerImp() throws RemoteException {
		super();

	}

	@Override
	public void createPlayer(GameController gameControllerService) {
		playerController = new SwingPresenter(gameControllerService,
				playerAttributes1, new Color(2, 2, 200), 0);
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

	@Override
	public Color getColor() throws RemoteException {
		// TODO Auto-generated method stub
		return playerController.getColor();
	}

	@Override
	public Color getOppColor() throws RemoteException {
		// TODO Auto-generated method stub
		return playerController.getOppColor();
	}

	@Override
	public void setPlayerId(PlayerId playerId) throws RemoteException {
		playerController.setPlayerId(playerId);

	}

}
