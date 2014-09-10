package RMITest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerId;

public class RemotePlayerControllerServer extends UnicastRemoteObject
		implements
			RemotePlayerController {

	protected RemotePlayerControllerServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String playerName) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public PlayerId getPlayerId() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void yourTurn() throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setGamecontroller(GameController gamecontroller)
			throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void endOfGame(ResultState resultGame) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getPlayerPoints() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PlayerAttributes getPlayerAttributes() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
