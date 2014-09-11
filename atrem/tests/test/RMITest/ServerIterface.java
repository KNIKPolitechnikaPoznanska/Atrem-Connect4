package test.RMITest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerIterface extends Remote {
	public void setPlayer(int i, PlayerInterface player) throws RemoteException;

	public PlayerInterface getPlayer(int i) throws RemoteException;

	public String getMessage() throws RemoteException;

	public void setMessage(String messag) throws RemoteException;

}// pawe³ to peda³
