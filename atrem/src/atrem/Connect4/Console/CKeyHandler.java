package atrem.Connect4.Console;

import java.awt.event.KeyAdapter;
import java.util.Scanner;

import atrem.Connect4.Game.Board;

public class CKeyHandler extends KeyAdapter {
	private int slot;

	CKeyHandler() {
	}

	public int getSlot(Board board) {
		slot = 0;

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (true) {
			boolean bError = true;
			while (bError) {
				if (input.hasNextInt())
					slot = input.nextInt();
				else {
					System.out.println("WprowadŸ liczbê!!!");
					input.next();
					continue;
				}
				bError = false;

				if (slot > 0 && slot <= board.getSlots()) {
					return slot - 1;
				} else {
					System.out.println("Wprowadzi³eœ z³y slot!");
					System.out.println("WprowadŸ slot z zakresu [0-"
							+ board.getSlots() + "]");
				}
			}
		}
	}

	public String getString() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String string = input.next();
		return string;
	}

	public int getInt() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int inputInt = input.nextInt();
		return inputInt;
	}
}
