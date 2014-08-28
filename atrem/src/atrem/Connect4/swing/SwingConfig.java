package atrem.Connect4.swing;

import javax.swing.JDialog;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class SwingConfig {
	private DialogSettingsBox dialogBox;
	private String player1name = "Gracz1", player2name = "Gracz2";
	private int slots = 7, rows = 6;
	private String opponent = "K";
	private boolean loaded = false;

	private void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public boolean isLoaded() {
		return loaded;
	}

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
		try {
			dialogBox = new DialogSettingsBox();
			dialogBox.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialogBox.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dialogBox.isLoaded())
			setLoaded(true);
	}

	public String getOpponent() {
		return opponent;
	}
}