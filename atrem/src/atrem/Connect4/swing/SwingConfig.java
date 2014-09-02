package atrem.Connect4.swing;

import javax.swing.JDialog;

/*
 * Pobiera od gracza wszystkie informacje
 * wymagane do uruchomienia gry
 */
public class SwingConfig {
	private DialogSettingsBox dialogBox;
	private String player1name, player2name;
	private int slots, rows;
	private String opponent;
	private boolean CPUmark;

	public void setDBox() {
		try {
			dialogBox = new DialogSettingsBox(this);
			dialogBox.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // do
																			// DialogSettingsBox
			dialogBox.setVisible(true); //
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setSettings() { // zmieniæ nazwe na setup
		player1name = dialogBox.getPl1Name();
		player2name = dialogBox.getPl2Name();
		rows = dialogBox.getRows();
		slots = dialogBox.getSlots();
		setCPUmark(dialogBox.isCPU());
		if (isCPUmark()) {
			setOpponent("K");
		} else
			setOpponent("C");
	}

	public String getOpponent() {
		return opponent;
	}

	public void setOpponent(String opponent) {
		this.opponent = opponent;
	}

	public String getPlayer1name() {
		return player1name;
	}

	public String getPlayer2name() {
		return player2name;
	}

	public void setPlayer1name(String player1name) {
		this.player1name = player1name;
	}

	public void setPlayer2name(String player2name) {
		this.player2name = player2name;
	}

	public int getRows() {
		return rows;
	}

	public int getSlots() {
		return slots;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setSlots(int slots) {
		this.slots = slots;
	}

	public boolean isCPUmark() {
		return CPUmark;
	}

	private void setCPUmark(boolean isCPU) {
		this.CPUmark = isCPU;
	}
}