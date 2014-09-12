package testy.game.remote;

import java.awt.Color;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import atrem.connect4.game.RemoteGameFactory;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerId;

public class Player1 {

	private PlayerAttributes playerAttributes;

	public void createRemotePlayer(String IP) {
		RemoteGameFactory remoteGameFactory = new RemoteGameFactory();
		remoteGameFactory.startConnection(IP);

		try {
			remoteGameFactory.createPlayer(playerAttributes);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	public Player1(PlayerAttributes playerAttributes) {
		this.playerAttributes = playerAttributes;
	}

	public static void main(String[] args) throws RemoteException,
			NotBoundException, InterruptedException {

		PlayerAttributes playerAttributes = new PlayerAttributes("kots",
				PlayerId.PLAYER1, 0, Color.GREEN);
		Player1 player = new Player1(playerAttributes);

		// player.createRemotePlayer();
	}

}
