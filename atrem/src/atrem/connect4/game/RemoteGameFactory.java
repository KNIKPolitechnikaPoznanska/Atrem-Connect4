package atrem.connect4.game;

import java.awt.Color;

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

	// private PlayerAttributes player;

	/**
	 * TODO zmodyfikowac game config na potrzbe remote Game Facoty
	 */
	private void readSettings() {
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

	public String getPlayer1name() {
		return player1name;
	}

	public int getRows() {
		return rows;
	}

	public PlayerAttributes getPlayer() {
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

	public RemoteGameFactory() {
		dialogBox = new DialogSettingsBox();
		readSettings();
	}
}
