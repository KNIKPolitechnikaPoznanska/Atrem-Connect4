package test.RMITest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class PlayerImpl extends UnicastRemoteObject implements PlayerInterface {

	/**
	 * 
	 */
	private Client1 client;
	private static final long serialVersionUID = -1629613503840180524L;

	protected PlayerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPlayer() {
		this.client = client;
	}

	@Override
	public String speak() throws RemoteException {
		return null;
	}

}
