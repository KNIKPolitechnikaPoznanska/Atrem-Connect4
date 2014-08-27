package atrem.Connect4.swing;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class SwingConfig {
	private String player1name = "Gracz1", player2name = "Gracz2";
	private int slots = 5, rows = 6;
	private String opponent = "K";

	public SwingConfig() {

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

	}

	public String getOpponent() {
		return opponent;
	}
}