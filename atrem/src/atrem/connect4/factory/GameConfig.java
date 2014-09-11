package atrem.connect4.factory;

import java.awt.Color;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class GameConfig {
	private String player1name, player2name, player1Type, player2Type,
			gamePl1Type, gamePl2Type;
	public static final String CHuman = "CZ£OWIEK", CcpuEasy = "CPU-Easy",
			CcpuMedium = "CPU-Medium", CcpuHard = "CPU-Hard";
	public static final String[] playerTypeItems = {CHuman, CcpuEasy,
			CcpuMedium, CcpuHard};
	public static final String DEF_PL1_NAME = "Gracz 1";
	public static final String DEF_PL2_NAME = "Gracz 2";
	public static final int DEF_SLOTS = 9, DEF_ROWS = 6;
	private int slots, rows;
	private GameFactory gameFactory;
	private PlayerFactory playerFactory;
	private Color token1Color, token2Color;
	private OnlineSettingsBox onlineBox;
	private OfflineSettingsBox offlineBox;
	private String adress;
	private int port;

	/**
	 * Tworzy Game i Player Factory.
	 */
	public GameConfig() {
		playerFactory = new PlayerFactory();
		gameFactory = new GameFactory(playerFactory);
	}

	/**
	 * Pokazuje okno ustawieñ Offline.
	 */
	public void showOfflineDBox() {
		try {
			offlineBox = new OfflineSettingsBox(this);
			offlineBox.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pokazuje okno ustawieñ Online.
	 */
	public void showOnlineDBox() {
		onlineBox = new OnlineSettingsBox(this);
		onlineBox.setVisible(true);
	}

	/**
	 * Pobierz dane z okna dialogowego do config.
	 */
	public void setupOfflineSettings() {
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
	 * Przypisuje dane z okna ustawieñ Online.
	 */
	public void setupOnlineClientSettings() {
		adress = onlineBox.getAdress();
		port = onlineBox.getPort();
		player1name = onlineBox.getPlayerName();
		token1Color = onlineBox.getColor();
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

	/**
	 * Tworzy dane do stworzenia serwerowego GC.
	 */
	public void setupServerGameFactory() {
		rows = DEF_ROWS;
		slots = DEF_SLOTS;
		gameFactory.setRows(rows);
		gameFactory.setSlots(slots);
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

	public Color getToken1Color() {
		return token1Color;
	}

	public String getAdress() {
		return adress;
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

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
}