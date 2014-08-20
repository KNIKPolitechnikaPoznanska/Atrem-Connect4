package atrem;

import java.awt.event.KeyAdapter;
import java.util.Scanner;

public class CKeyHandler extends KeyAdapter {

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
}
