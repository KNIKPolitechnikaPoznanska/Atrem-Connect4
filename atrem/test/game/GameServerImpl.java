package testy.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GameServerImpl extends UnicastRemoteObject implements GameServer {

	PlayerInterface[] players = new PlayerInterface[2];

	public GameServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setPlayer(int i, PlayerInterface player) throws RemoteException {
		players[i] = player;

	}

	@Override
	public PlayerInterface getPlayer(int i) throws RemoteException {
		return players[i];
	}

}
