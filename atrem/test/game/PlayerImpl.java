package testy.game;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PlayerImpl extends UnicastRemoteObject implements PlayerInterface {

	protected PlayerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void makeMove(String string) throws RemoteException {
		System.out.println("Ktoœ wykona³ ruch " + string);
	}

}
