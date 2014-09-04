package atrem.Connect4.swing;

import javax.swing.JOptionPane;

public class DialogInformationBoxes {

	public void winMessage(String name) {
		JOptionPane.showMessageDialog(null, "Koniec gry. Wygra³ " + name);

	}

	public void drawMessage() {
		JOptionPane.showMessageDialog(null, "Koniec gry. Remis.");
	}

	public void fullSlotMessage() {
		JOptionPane.showMessageDialog(null,
				"Wybrany slot jest pe³en. Podaj inny!");
	}

}
