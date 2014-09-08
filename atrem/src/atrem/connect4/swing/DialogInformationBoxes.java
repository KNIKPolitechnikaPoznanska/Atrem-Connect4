package atrem.connect4.swing;

import javax.swing.JOptionPane;

public class DialogInformationBoxes {

	public int winMessage(String name) {
		Object[] options = { "Tak, gram dalej", "Nie, idŸ do menu",
				"Zamknij grê" };
		int decision = JOptionPane.showOptionDialog(null, "Wygra³ gracz "
				+ name + "! \n Czy chcesz rozegrac kolejna partie? ",
				"Co robimy?", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

		return decision;

	}

	public void drawMessage() {
		JOptionPane.showMessageDialog(null, "Koniec gry. Remis.");
	}

	public void fullSlotMessage() {
		JOptionPane.showMessageDialog(null,
				"Wybrany slot jest pe³en. Podaj inny!");
	}

}
