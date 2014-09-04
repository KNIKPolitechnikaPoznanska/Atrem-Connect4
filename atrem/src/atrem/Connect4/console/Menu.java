package atrem.Connect4.console;

import atrem.Connect4.Connect4Console;
import atrem.Connect4.Game.GameFactory;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class Menu {
	private KeyHandler keyGo;
	private String player1name, player2name;
	private int slots, rows;
	private String opponent, gamePl1Type, gamePl2Type;
	private GameFactory gameFactory;

	public Menu(GameFactory gameFactory) {
		this.gameFactory = gameFactory;
		keyGo = new KeyHandler();
		loadSettings();
		setupGameFactory();
	}

	private void setupGameFactory() {
		gameFactory.setRows(rows);
		gameFactory.setSlots(slots);
		gameFactory.setOpponent(opponent);
		gameFactory.setPlayer1Name(player1name);
		gameFactory.setPlayer2Name(player2name);
		gameFactory.setBoard();
		gameFactory.setGamePl1Type(gamePl1Type);
		gameFactory.setGamePl2Type(gamePl2Type);

	}

	private void loadSettings() {
		System.out.println("Witamy w grze connect 4");

		System.out.println("Podaj liczbe wierszy (wiêkszš od 3)");
		rows = keyGo.getInt();

		System.out.println("Podaj liczbe slotów, (wiêkszš od 3)");
		slots = keyGo.getInt();

		System.out.println("Chcesz grac z komputerem czy cz³owiekiem (K/C)?");
		opponent = keyGo.getStringChoice();

		System.out.println("Podaj imie pierwszego zawodnika ");
		player1name = keyGo.getString();

		if (opponent.equalsIgnoreCase("C"))
			System.out.println("Podaj imie drugiego zawodnika");
		else
			System.out.println("Podaj imie komputera");
		player2name = keyGo.getString();

		gamePl1Type = "console";
		gamePl2Type = "console";
	}

	public String getOpponent() {
		return opponent;
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

	public void runGame() {
		new Connect4Console().init(this, gameFactory);
	}
}