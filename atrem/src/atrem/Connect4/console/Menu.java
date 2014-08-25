package atrem.Connect4.console;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class Menu {
	private KeyHandler keyGo;
	private String player1name, player2name;
	private int slots, rows;
	private String opponent;

	public Menu() {
		keyGo = new KeyHandler();
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

		System.out.println("Witamy w grze connect 4");

		System.out.println("Podaj liczbe wierszy (wiêkszš od 3)");
		rows = keyGo.getInt();

		System.out.println("Podaj liczbe slotów, (wiêkszš od 3)");
		slots = keyGo.getInt();

		System.out.println("Chcesz grac z komputerem czy cz³owiekiem (K/C)?");
		opponent = keyGo.getStringChoice();

		System.out.println("Podaj imie pierwszego zawodnika ");
		player1name = keyGo.getString();

		// System.out.println("Podaj imie zawodnika " + player.getName() +
		// ": "); na przyszlosc dla wielu graczy
		// player1 = new Player(im, HoleState.PLAYER1);
		if (opponent.equalsIgnoreCase("C"))
			System.out.println("Podaj imie drugiego zawodnika");
		else
			System.out.println("Podaj imie komputera");
		player2name = keyGo.getString();
	}

	public String getOpponent() {
		return opponent;
	}
}