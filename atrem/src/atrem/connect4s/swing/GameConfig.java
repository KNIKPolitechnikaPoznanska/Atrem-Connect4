package atrem.connect4s.swing;

import java.awt.Color;

import atrem.connect4s.Games.GameFactory;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class GameConfig {
	private DialogSettingsBox dialogBox;
	private String player1name, player2name, player1Type, player2Type,
			gamePl1Type, gamePl2Type;
	public static final String CHuman = "CZ£OWIEK", CcpuEasy = "CPU-Easy",
			CcpuMedium = "CPU-Medium", CcpuHard = "CPU-Hard";
	public static final String[] playerTypeItems = {CHuman, CcpuEasy,
			CcpuMedium, CcpuHard};
	public static final String DEF_PL1_NAME = "Gracz 1",
			DEF_PL2_NAME = "Gracz 2";
	public static final int DEF_SLOTS = 7, DEF_ROWS = 6;
	private int slots, rows;
	private GameFactory gameFactory;
	private Color token1Color, token2Color;

	public GameConfig(GameFactory gameFactory) {
		this.gameFactory = gameFactory;
	}

	/**
	 * Tworzy i wyœwietla Dailog Settings Box'a
	 */
	public void setDBox() {
		try {
			dialogBox = new DialogSettingsBox(this, gameFactory);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Pobierz dane z okna dialogowego do config.
	 */
	public void setupSettings() {
		player1name = dialogBox.getPl1Name();
		player2name = dialogBox.getPl2Name();

		rows = dialogBox.getRows();
		slots = dialogBox.getSlots();

		player1Type = dialogBox.getPl1Type();
		player2Type = dialogBox.getPl2Type();

		gamePl1Type = dialogBox.getPl1GameType();
		gamePl2Type = dialogBox.getPl2GameType();

		token1Color = dialogBox.getToken1Color();
		token2Color = dialogBox.getToken2Color();
	}
	/**
	 * Ustaw gameFactory wartoœciami z Config.
	 */
	public void setupGameFactory() {
		gameFactory.setRows(rows);
		gameFactory.setSlots(slots);

		gameFactory.setPlayer1Type(player1Type);
		gameFactory.setPlayer2Type(player2Type);

		gameFactory.setPlayer1Name(player1name);
		gameFactory.setPlayer2Name(player2name);

		gameFactory.setGamePl1Type(gamePl1Type);
		gameFactory.setGamePl2Type(gamePl2Type);

		gameFactory.setToken1Color(token1Color);
		gameFactory.setToken2Color(token2Color);

		gameFactory.setBoard();
	}
	public String getPlayer1Type() {
		return player1Type;
	}

	public void setPlayerType(String player1Type) {
		this.player1Type = player1Type;
	}

	public String getPlayer1name() {
		return player1name;
	}

	public String getPlayer2name() {
		return player2name;
	}

	public void setPlayer1name(String player1name) {
		this.player1name = player1name;
	}

	public void setPlayer2name(String player2name) {
		this.player2name = player2name;
	}

	public int getRows() {
		return rows;
	}

	public int getSlots() {
		return slots;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}
}
