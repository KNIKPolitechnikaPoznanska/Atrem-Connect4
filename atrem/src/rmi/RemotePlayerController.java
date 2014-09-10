package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

import atrem.connect4.game.GameController;
import atrem.connect4.game.ResultState;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerId;

public interface RemotePlayerController extends Remote {
	public String getName() throws RemoteException;

	public abstract void setName(String playerName) throws RemoteException;

	public abstract PlayerId getPlayerId() throws RemoteException;

	public abstract void yourTurn() throws RemoteException;

	public abstract void setGamecontroller(GameController gamecontroller)
			throws RemoteException;

	public abstract void endOfGame(ResultState resultGame)
			throws RemoteException;

	public abstract int getPlayerPoints() throws RemoteException;

	public abstract PlayerAttributes getPlayerAttributes()
			throws RemoteException;

}
