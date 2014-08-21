package atrem.Connect4.Console;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class Menu {
	private CKeyHandler menu;
	private String player1name, player2name;
	private int slots, rows;

	public Menu() {
		menu = new CKeyHandler();
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

	public void loadSettings() {
		menu = new CKeyHandler();
		System.out.println("Witamy w grze connect 4");

		System.out.println("Podaj liczbe wierszy wiêksz¹ od 3");
		rows = menu.getInt();

		System.out.println("Podaj liczbe slotów wiêksz¹ od 3");
		slots = menu.getInt();

		System.out.println("Podaj imie pierwszego zawodnika ");
		player1name = menu.getString();

		// System.out.println("Podaj imie zawodnika " + player.getName() +
		// ": "); na przyszlosc dla wielu graczy
		// player1 = new Player(im, HoleState.PLAYER1);

		System.out.println("Podaj imie drugiego zawodnika");
		player2name = menu.getString();
	}
}
