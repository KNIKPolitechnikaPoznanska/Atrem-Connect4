package atrem.Connect4.Console;

import java.util.Scanner;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Player;

public class Menu { // GameFactory
	private Board board;
	private Player player1, player2;

	public Menu(Board board, Player player1, Player player2) {// rozbicie na
																// metody
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		System.out.println("Witamy w grze connect 4");
		System.out.println("Podaj liczbe wierszy");
		int Rows = in.nextInt();
		System.out.println("Podaj liczbe slotow");
		int Slots = in.nextInt();
		board = new Board(Rows, Slots);

		System.out.println("Podaj imie pierwszego zawodnika");
		String im = in.next();
		player1 = new Player(im, HoleState.PLAYER1);
		System.out.println("Podaj imie drugiego zawodnika");
		im = in.next();
		player2 = new Player(im, HoleState.PLAYER2);
		sendBoard(board, player1, player2);
	}

	public void sendBoard(Board board, Player player1, Player player2) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
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
