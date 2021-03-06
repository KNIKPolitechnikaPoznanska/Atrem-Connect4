package atrem.connect4.console;

import atrem.connect4.Connect4Console;
import atrem.connect4.game.GameConfig;
import atrem.connect4.game.GameFactory;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class Menu {
	private KeyHandler keyGo;
	private String player1name, player2name, gamePl1Type, gamePl2Type,
			player1Type, player2Type, tempKey;
	private int slots, rows;
	private GameFactory gameFactory;
	private Connect4Console console;

	public Menu(GameFactory gameFactory) {
		this.gameFactory = gameFactory;
		keyGo = new KeyHandler();
		loadSettings();
		setupGameFactory();
	}

	/**
	 * Ustawia GameFactory do utworzenia Kontrolera
	 */
	private void setupGameFactory() {
		gameFactory.setRows(rows);
		gameFactory.setSlots(slots);
		gameFactory.setPlayer1Name(player1name);
		gameFactory.setPlayer2Name(player2name);
		gameFactory.setBoard();
		gameFactory.setGamePl1Type(gamePl1Type);
		gameFactory.setGamePl2Type(gamePl2Type);
		gameFactory.setPlayer1Type(player1Type);
		gameFactory.setPlayer2Type(player2Type);
	}

	/**
	 * Pobiera od u�ytkownika przez konsole ustawienia gry.
	 */
	private void loadSettings() {
		System.out.println("Witamy w grze Connect 4");

		System.out.println("Podaj liczbe wierszy (wi�ksza od 3)");
		rows = keyGo.getInt();
		System.out.println("Podaj liczbe slot�w, (wi�ksza od 3)");
		slots = keyGo.getInt();

		System.out.println("Gracz 1: komputer czy cz�owiek (K/C)?");
		tempKey = keyGo.getStringChoice();
		if (tempKey.equalsIgnoreCase("K"))
			player1Type = GameConfig.CcpuMedium;
		if (tempKey.equalsIgnoreCase("C"))
			player1Type = GameConfig.CHuman;
		System.out.println("Gracz 2: komputer czy cz�owiek (K/C)?");
		tempKey = keyGo.getStringChoice();
		if (tempKey.equalsIgnoreCase("K"))
			player2Type = GameConfig.CcpuMedium;
		if (tempKey.equalsIgnoreCase("C"))
			player2Type = GameConfig.CHuman;

		System.out.println("Podaj imie pierwszego zawodnika ");
		player1name = keyGo.getString();
		System.out.println("Podaj imie drugiego zawodnika ");
		player2name = keyGo.getString();

		gamePl1Type = "console";
		gamePl2Type = "console";
	}

	/**
	 * Uruchamia gr� w konsoli.
	 */
	public void runGame() {
		console = new Connect4Console(gameFactory);
		console.init();
	}

	public String getPlayer1name() {
		return player1name;
	}

	public String getPlayer2name() {
		return player2name;
	}

	public int getRows() {
		return rows;
	}

	public int getSlots() {
		return slots;
	}
}