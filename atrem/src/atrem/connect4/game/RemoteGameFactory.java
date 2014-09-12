package atrem.connect4.game;

import java.awt.Color;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import testy.game.remote.LocalGameController;
import testy.game.remote.RemoteGameController;
import testy.game.remote.RemotePlayerControlerImpl;
import testy.game.remote.RemotePlayerController;
import atrem.connect4.game.player.PlayerAttributes;
import atrem.connect4.game.player.PlayerId;
import atrem.connect4.swing.DialogSettingsBox;

public class RemoteGameFactory {

	private DialogSettingsBox dialogBox;
	private String player1name;
	private int rows;
	private int slots;
	private String player1Type;
	private String gamePl1Type;
	private Color token1Color;
	private PlayerAttributes playerAttributes;
	private RemoteGameController connect;
	private GameController gameController;
	private RemotePlayerController player;

	// private PlayerAttributes player;
	public RemoteGameFactory() {
		// dialogBox = new DialogSettingsBox();
		// this.waitForDialogBox();
		try {
			player = new RemotePlayerControlerImpl();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		// playerAttributes = new PlayerAttributes("patryk", PlayerId.PLAYER1,
		// 0,
		// Color.BLUE);

	}

	/**
	 * TODO zmodyfikowac game config na potrzbe remote Game Facoty
	 */
	public void readSettings() {
		// TODO Auto-generated method stub
		player1name = dialogBox.getPl1Name();
		rows = dialogBox.getRows();
		slots = dialogBox.getSlots();
		player1Type = dialogBox.getPl1Type();
		gamePl1Type = dialogBox.getPl1GameType();
		token1Color = dialogBox.getToken1Color();
		playerAttributes = new PlayerAttributes(player1Type, PlayerId.PLAYER1,
				0, token1Color);
	}

	public void startConnection() {
		Registry r;
		try {
			r = LocateRegistry.getRegistry(80);
			// Registry r = LocateRegistry.getRegistry("10.7.7.152", 80);
			// Registry r = LocateRegistry.getRegistry("10.7.7.155", 1234);
		} catch (RemoteException e) {
			e.printStackTrace();
			System.out.println("blad polaczenia");
			throw new Error();
		}
		try {
			connect = (RemoteGameController) r.lookup("connect");
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}

	}

	public void createPlayer() throws RemoteException {

		gameController = new LocalGameController(connect);

		PlayerId playerId = connect.addPlayer(player);
		if (playerId == PlayerId.PLAYER1)
			playerAttributes = gameController.getPlayer1Attributes();
		if (playerId == PlayerId.PLAYER2)
			playerAttributes = gameController.getPlayer2Attributes();
		playerAttributes.setPlayerId(playerId);
		player.createPlayer(gameController, playerAttributes);

	}

	public synchronized void waitForDialogBox() {
		try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getPlayer1name() {
		return player1name;
	}

	public int getRows() {
		return rows;
	}

	public PlayerAttributes getPlayerAttributes() {
		return playerAttributes;
	}

	public int getSlots() {
		return slots;
	}

	public String getPlayer1Type() {
		return player1Type;
	}

	public String getGamePl1Type() {
		return gamePl1Type;
	}

	public Color getToken1Color() {
		return token1Color;
	}

}
