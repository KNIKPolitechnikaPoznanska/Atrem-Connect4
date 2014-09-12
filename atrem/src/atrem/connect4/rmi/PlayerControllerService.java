package atrem.connect4.rmi;

import java.awt.Color;
import java.rmi.RemoteException;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerController;
import atrem.connect4.game.player.PlayerId;

public class PlayerControllerService implements PlayerController {
	private RemotePlayerController remotePlayerController;

	public PlayerControllerService(RemotePlayerController remotePlayerController) {
		this.remotePlayerController = remotePlayerController;
	}

	@Override
	public String getName() {
		try {
			return remotePlayerController.getName();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("RemotePlayerController: getName");
		}
		return null;
	}

	@Override
	public void setName(String playerName) {
		try {
			remotePlayerController.setName(playerName);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("RemotePlayerController: setName");
		}
	}

	@Override
	public PlayerId getPlayerId() {
		try {
			return remotePlayerController.getPlayerId();
		} catch (RemoteException e) {
			System.out.println("RemotePlayerController: getID");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void yourTurn() {
		try {
			remotePlayerController.yourTurn();
		} catch (RemoteException e) {
			System.out.println("RemotePlayerController: yourTurn");
			e.printStackTrace();
		}
	}

	@Override
	public void opponentConnected() {
		try {
			remotePlayerController.opponentConnected();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endOfGame(ResultState resultGame) {
		try {
			remotePlayerController.endOfGame(resultGame);
		} catch (RemoteException e) {
			System.out.println("RemotePlayerController: endgame");
			e.printStackTrace();
		}
	}

	@Override
	public void setGamecontroller(GameController gamecontroller) {
		try {
			remotePlayerController.setGamecontroller(gamecontroller);
		} catch (RemoteException e) {
			System.out.println("RemotePlayerController: GC");
			e.printStackTrace();
		}
	}

	@Override
	public int getPlayerPoints() {
		try {
			return remotePlayerController.getPlayerPoints();
		} catch (RemoteException e) {
			System.out.println("Wyjatek w remotePlayerController");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public PlayerAttributes getPlayerAttributes() {
		try {
			return remotePlayerController.getPlayerAttributes();
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("Wyjatek w remotePlayerController");
		}
		return null;
	}

	@Override
	public Color getColor() {
		try {
			return remotePlayerController.getColor();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Color getOppColor() {
		try {
			return remotePlayerController.getOppColor();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void setPlayerId(PlayerId playerId) {
		try {
			remotePlayerController.getPlayerAttributes().setPlayerId(playerId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}