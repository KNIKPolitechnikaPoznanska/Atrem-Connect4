package atrem.Connect4.Console;

import java.awt.event.KeyAdapter;
import java.util.Scanner;

/*
 * Klasa obs�uguj�ca klawiatur� 
 * i pobieraj�ca prawid�owe warto�ci
 * podane przez graczy
 */
public class CKeyHandler extends KeyAdapter {
	private int slot;
	private int inputInt;

	public int getSlot(int maxSlots) {
		slot = 0;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		while (true) {
			boolean bError = true;
			while (bError) {
				if (input.hasNextInt()) {
					slot = input.nextInt();
				} else {
					System.out.println("Wprowad� liczb�!!!");
					input.next();
					continue;
				}
				bError = false;
				// input.close();

				if (slot > 0 && slot <= maxSlots) {
					return slot - 1;
				} else {
					System.out.println("Wprowadzi�e� z�y slot!");
					System.out.println("Wprowad� slot z zakresu [0-" + maxSlots
							+ "]");
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

	public String getStringChoice() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String string = input.next();
		while (!string.equalsIgnoreCase("K") && !string.equalsIgnoreCase("C")) {
			System.out.println("Wprowad� K(komputer) lub C(cz�owiek)5");
			string = input.next();

		}
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
					System.out.println("Wprowad� liczb�!!!");
					input.next();
					continue;
				}
			}

			if (inputInt > 3) {
				// input.close();
				return inputInt;
			} else {
				System.out.println("Wprowad� liczb� z zakresu [4-n]");
			}
		}
	}
}
