package atrem.Connect4.swing;

import javax.swing.JOptionPane;

public class DialogInformationBoxes {

	public void winMessage(String name) {
		JOptionPane.showMessageDialog(null, "Koniec gry. Wygra� " + name);

	}

	public void drawMessage() {

	}

	public void fullSlotMessage() {
		JOptionPane.showMessageDialog(null,
				"Wybrany slot jest pe�en. Podaj inny!");
	}

}
