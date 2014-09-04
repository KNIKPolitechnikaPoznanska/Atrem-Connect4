package atrem.Connect4.swing;

import javax.swing.JOptionPane;

public class DialogInformationBoxes {

	public int winMessage(String name) {
		Object[] options = { "Tak, gram dalej", "Nie, koniec", "Zamknij grê" };
		int decision = JOptionPane.showOptionDialog(null, "Wygra³ gracz "
				+ name + "! \n Czy chcesz rozegrac kolejna partie? ",
				"Co robimy?", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, options, options[2]);

		return decision;

	}

	public void drawMessage() {

	}

	public void fullSlotMessage() {
		JOptionPane.showMessageDialog(null,
				"Wybrany slot jest pe³en. Podaj inny!");
	}

}
