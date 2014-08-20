package atrem.Connect4.Console;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Player;

public class Menu { // GameFactory
	private Board board;
	private String player1name, player2name;
	private CKeyHandler menu;
	private int slots, rows;

	public Menu() {

		menu = new CKeyHandler();
		settings();

		sendSettings();
	}

	public void settings() {
		menu = new CKeyHandler();
		System.out.println("Witamy w grze connect 4");
		System.out.println("Podaj liczbe wierszy");
		rows = menu.getInt();
		System.out.println("Podaj liczbe slotow");
		slots = menu.getInt();
		System.out.println("Podaj imie pierwszego zawodnika");
		player1name = menu.getString();

		// System.out.println("Podaj imie zawodnika " + player.getName() +
		// ": "); na przyszlosc dla wielu graczy
		// player1 = new Player(im, HoleState.PLAYER1);

		System.out.println("Podaj imie drugiego zawodnika");
		player2name = menu.getString();

	}

	public void sendSettings() {

	}

	public Board getBoard() {
		return board;
	}

	public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

}
