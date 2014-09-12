package atrem.connect4.game;

import java.awt.Color;

import testy.game.remote.LocalGameController;
import testy.game.remote.Player1;
import testy.game.remote.RemoteGameController;
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
	private PlayerAttributes player;
	private Player1 main;
	private RemoteGameController connect;
	GameController gameController;

	// private PlayerAttributes player;
	public RemoteGameFactory(RemoteGameController gameController) {
		// SwingUtilities.invokeLater(new Runnable() {
		//
		// @Override
		// public void run() {
		// (RemoteGameFactory.this);
		//
		// }
		// });
		this.connect = gameController;
		this.gameController = new LocalGameController(connect);
		dialogBox = new DialogSettingsBox(this);
		this.waitForDialogBox();

		// readSettings();
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
		player = new PlayerAttributes(player1Type, PlayerId.PLAYER1, 0,
				token1Color);
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
		return player;
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
