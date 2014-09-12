package testy.game.remote;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import atrem.connect4.game.RemoteGameFactory;

public class Player1 {

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {

		Player1 player = new Player1();

		player.createRemotePlayer();
	}

	public void createRemotePlayer() {
		RemoteGameFactory remoteGameFactory = new RemoteGameFactory();
		remoteGameFactory.startConnection();

		try {
			remoteGameFactory.createPlayer();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
