package atrem.connect4.game;

import java.awt.Color;

import atrem.connect4.factory.GameFactory;
import atrem.connect4.factory.GameModeSelectionBox;
import atrem.connect4.factory.OfflineSettingsBox;
import atrem.connect4.factory.OnlineSettingsBox;
import atrem.connect4.factory.PlayerFactory;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class GameConfig {
	private GameModeSelectionBox gameModeSelectionBox;
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
	private PlayerFactory playerFactory;
	private Color token1Color, token2Color;
	private OnlineSettingsBox onlineBox;
	private OfflineSettingsBox offlineBox;

	public GameConfig() {
		playerFactory = new PlayerFactory();
		gameFactory = new GameFactory(playerFactory);
	}

	public void showOfflineDBox() {
		try {
			offlineBox = new OfflineSettingsBox(this);
			offlineBox.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showOnlineDBox() {
		onlineBox = new OnlineSettingsBox(this);
		onlineBox.setVisible(true);
	}

	/**
	 * Pobierz dane z okna dialogowego do config.
	 */
	public void setupSettings() {
		player1name = offlineBox.getPl1Name();
		player2name = offlineBox.getPl2Name();

		rows = offlineBox.getRows();
		slots = offlineBox.getSlots();

		player1Type = offlineBox.getPl1Type();
		player2Type = offlineBox.getPl2Type();

		gamePl1Type = offlineBox.getPl1GameType();
		gamePl2Type = offlineBox.getPl2GameType();

		token1Color = offlineBox.getToken1Color();
		token2Color = offlineBox.getToken2Color();
	}
	/**
	 * Ustaw gameFactory wartoœciami z Config.
	 */
	public void setupGameFactory() {
		gameFactory.setRows(rows);
		gameFactory.setSlots(slots);

		playerFactory.setPlayer1Type(player1Type);
		playerFactory.setPlayer2Type(player2Type);

		playerFactory.setPlayer1Name(player1name);
		playerFactory.setPlayer2Name(player2name);

		playerFactory.setGamePl1Type(gamePl1Type);
		playerFactory.setGamePl2Type(gamePl2Type);

		playerFactory.setToken1Color(token1Color);
		playerFactory.setToken2Color(token2Color);

		gameFactory.setBoard();
	}

	public GameFactory getGameFactory() {
		return gameFactory;
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

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getSlots() {
		return slots;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}
}
