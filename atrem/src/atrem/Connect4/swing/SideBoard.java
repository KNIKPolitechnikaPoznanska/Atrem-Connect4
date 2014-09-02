package atrem.Connect4.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SideBoard extends JPanel {
	String message;
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9208904490186715373L;

	public SideBoard() {

		ResourceLoader iconResource = new ResourceLoader();
		int PlayerID = 1;

		setLayout(null);

		JPanel namesAndColours = new JPanel();
		namesAndColours.setBounds(10, 11, 169, 115);
		add(namesAndColours);
		namesAndColours.setLayout(null);

		JLabel player1 = new JLabel("g1");
		player1.setBounds(5, 16, 91, 14);
		namesAndColours.add(player1);

		JLabel token1 = new JLabel("");
		token1.setBounds(119, 3, 40, 40);
		namesAndColours.add(token1);
		token1.setIcon(iconResource.get(PlayerID)); // obrazek widzoczny arg
													// plID [0-2] BARTEK

		JLabel player2 = new JLabel("g2");
		player2.setBounds(5, 78, 91, 14);
		namesAndColours.add(player2);

		JLabel token2 = new JLabel("");
		token2.setBounds(119, 65, 40, 40);
		namesAndColours.add(token2);
		token2.setIcon(null); // do metody bez obrazka BARTEK

		/**
		 * do komunikacji z graczem ! BARTEK
		 */

		JLabel dialogWinow = new JLabel(message);
		dialogWinow.setVerticalAlignment(SwingConstants.TOP);
		dialogWinow.setBounds(8, 137, 169, 129);
		add(dialogWinow);

	}

	/**
	 * 
	 * METODY
	 */

	public void sendMessage(String message) {
		message = "Witamy w Connect4!";
		this.message = message;
	}

	public void displayToken(int i) {

	}
}