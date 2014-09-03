package atrem.Connect4.swing;

import javax.swing.JOptionPane;

import atrem.Connect4.Game.PlayerId;

public class DialogInformationBoxes {

	public void winMessage(PlayerId playerTurn) {

	}

	public void drawMessage() {

	}

	public void fullSlotMessage() {
		JOptionPane.showMessageDialog(null,
				"Wybrany slot jest pe³en. Podaj inny!");
	}

}
