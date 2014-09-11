package test.RMITest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl extends UnicastRemoteObject implements ServerIterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9156413967679709516L;

	protected ServerImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	PlayerInterface player1, player2;
	String message;

	@Override
	public String getMessage() throws RemoteException {
		return message;
	}

	@Override
	public void setMessage(String message) throws RemoteException {
		this.message = message;
	}

	@Override
	public void setPlayer(int i, PlayerInterface player) throws RemoteException {
		if (i == 1)
			player1 = player;
		else if (i == 2)
			player2 = player;

	}

	@Override
	public PlayerInterface getPlayer(int i) throws RemoteException {
		if (i == 1) {
			System.out.println("to jest player1");
			return player1;
		} else if (i == 2)
			return player2;
		return null;
	}

}
