package atrem.Connect4.Console;

import java.awt.event.KeyAdapter;
import java.util.Scanner;

import atrem.Connect4.Game.Board;

/*
 * Klasa obs³uguj¹ca klawiaturê 
 * i pobieraj¹ca prawid³owe wartoœci
 * podane przez graczy
 */
public class CKeyHandler extends KeyAdapter {
	private int slot;
	private int inputInt;

	public int getSlot(Board board) {
		slot = 0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (true) {
			boolean bError = true;
			while (bError) {
				if (input.hasNextInt()) {
					slot = input.nextInt();
				} else {
					System.out.println("WprowadŸ liczbê!!!");
					input.next();
					continue;
				}
				bError = false;
				// input.close();

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
		inputInt = 0;
		boolean bError;
		while (true) {
			bError = true;
			while (bError) {
				if (input.hasNextInt()) {
					inputInt = input.nextInt();
					bError = false;
				} else {
					System.out.println("WprowadŸ liczbê!!!");
					input.next();
					continue;
				}
			}

			if (inputInt > 3) {
				// input.close();
				return inputInt;
			} else {
				System.out.println("WprowadŸ liczbê z zakresu [4-n]");
			}
		}
	}
}
