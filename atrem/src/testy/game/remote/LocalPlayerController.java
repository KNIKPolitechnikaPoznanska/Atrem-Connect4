package testy.game.remote;

import java.rmi.RemoteException;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public class LocalPlayerController implements PlayerController {
	private RemotePlayerController remotePlayerController;

	public LocalPlayerController(RemotePlayerController remotePlayerController) {

		this.remotePlayerController = remotePlayerController;
	}

	@Override
	public String getName() {
		String name;
		try {
			name = remotePlayerController.getName();
		} catch (RemoteException e) {
			name = "nie wczytalem imienia";
			e.printStackTrace();
		}
		return name;
	}

	@Override
	public void setName(String playerName) {
		try {
			remotePlayerController.setName(playerName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public PlayerId getPlayerId() {
		PlayerId playerId = null;
		try {
			playerId = remotePlayerController.getPlayerId();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return playerId;
	}

	@Override
	public void yourTurn() {
		try {
			remotePlayerController.yourTurn();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		try {
			remotePlayerController.setGamecontroller(gamecontroller);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void endOfGame(ResultState resultGame) {
		try {
			remotePlayerController.endOfGame(resultGame);
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int getPlayerPoints() {
		int points = 0;
		try {
			points = remotePlayerController.getPlayerPoints();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return points;
	}

	@Override
	public PlayerAttributes getPlayerAttributes() {
		PlayerAttributes playerAttributes = null;
		try {
			remotePlayerController.getPlayerAttributes();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return playerAttributes;
	}

	public RemotePlayerController getRemotePlayerController() {
		return remotePlayerController;
	}

	public void setRemotePlayerController(
			RemotePlayerController remotePlayerController) {
		this.remotePlayerController = remotePlayerController;
	}

}
