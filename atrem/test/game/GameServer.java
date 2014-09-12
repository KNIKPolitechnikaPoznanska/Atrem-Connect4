package testy.game;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GameServer extends Remote {

	public void setPlayer(int i, PlayerInterface player) throws RemoteException;

	public PlayerInterface getPlayer(int i) throws RemoteException;
}
