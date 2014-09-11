package test.tgame;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PlayerInterface extends Remote {

	public void makeMove(String string) throws RemoteException;
}
