package multiplayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GameServer extends UnicastRemoteObject implements IConnect4Server {

	public GameServer() throws RemoteException {
		super();

	}

}
