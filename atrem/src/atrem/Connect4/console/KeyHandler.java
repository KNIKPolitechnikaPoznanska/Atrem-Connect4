package atrem.Connect4.console;

import java.awt.event.KeyAdapter;
import java.util.Scanner;

import atrem.Connect4.Game.board.Board;

/*
 * Klasa obs³uguj¹ca klawiaturê 
 * i pobieraj¹ca prawid³owe wartoœci
 * podane przez graczy
 */
public class KeyHandler extends KeyAdapter {
	private int maxSlots;

	public KeyHandler() {
	}

	public KeyHandler(Board board) {
		this.maxSlots = board.getSlots();
	}

	public int getInt() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while (true) {
			if (input.hasNextInt()) {
				int inputInt = input.nextInt();
				if (inputInt > 3) {
					return inputInt;
				} else {
					System.out.println("Wprowad�� liczb� z zakresu [4-n]");
				}
			} else {
				System.out.println("Wprowad��� liczb�!!!");
				input.next();
			}
		}
	}

	public int getSlot() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		while (true) {
			if (input.hasNextInt()) {
				int slot = input.nextInt();
				if (slot > 0 && slot <= maxSlots) {
					return slot - 1;
				} else {
					System.out.println("WprowadŸ slot z zakresu [0-"
							+ maxSlots + "]");
				}
			} else {
				System.out.println("WprowadŸ liczbê!!!");
				input.next();
			}
		}
	}

	public String getString() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String string = input.next();
		return string;
	}

	public String getStringChoice() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String string = input.next();
		while (!string.equalsIgnoreCase("K") && !string.equalsIgnoreCase("C")) {
			System.out.println("Wprowad�� K(komputer) lub C(cz�owiek)!");
			string = input.next();
		}
		return string;
	}
}