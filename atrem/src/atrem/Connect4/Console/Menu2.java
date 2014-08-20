package atrem.Connect4.Console;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Player;

public class Menu2 { // GameFactory
	private Board board;
	private Player player1, player2;
	private CKeyHandler menu;

	public Menu2() {

		menu = new CKeyHandler();
		settings();

		sendBoard();
	}

	public void settings() {
		menu = new CKeyHandler();
		System.out.println("Witamy w grze connect 4");
		System.out.println("Podaj liczbe wierszy");
		menu.setMaxRows();
		System.out.println("Podaj liczbe slotow");
		menu.setMaxSlots();
		System.out.println("Podaj imie pierwszego zawodnika");
		menu.getPlayerName(1);

		// System.out.println("Podaj imie zawodnika " + player.getName() +
		// ": "); na przyszlosc dla wielu graczy
		// player1 = new Player(im, HoleState.PLAYER1);

		System.out.println("Podaj imie drugiego zawodnika");
		im = in.next();
		player2 = new Player(im, HoleState.PLAYER2);

	}

	public void sendBoard() {

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
