package atrem.Connect4.Console;

import java.awt.event.KeyAdapter;
import java.util.Scanner;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.HoleState;
import atrem.Connect4.Game.Player;

public class CKeyHandler extends KeyAdapter {
	private int maxSlots;
	private int maxRows;

	CKeyHandler() {
	}

	public void getSlot(Board board) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while (true) {
			int slot = input.nextInt();
			if (slot > 0 && slot < board.getSlots()) {
				return;
			} else {
				System.out.println("Wprowadzi³eœ z³y slot!");
				System.out.println("WprowadŸ slot z zakresu [0-"
						+ board.getSlots() + "]");
			}

		}
	}

	public Player getPlayerName(Player player) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Podaj imie zawodnika " + player.getName() + ": ");
		String imie = input.next();
		player = new Player(imie, HoleState.PLAYER1);
		return player;
	}

	public void setMaxSlots() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int inputslots = input.nextInt();
		maxSlots = inputslots;
	}

	public void setMaxRows() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int inputrows = input.nextInt();
		maxRows = inputrows;
	}

	public int getMaxRows() {
		return maxRows;
	}

	public int getMaxSlots() {
		return maxSlots;
	}
}
