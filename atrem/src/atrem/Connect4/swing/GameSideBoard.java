package atrem.Connect4.swing;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import atrem.Connect4.Game.board.HoleState;

public class GameSideBoard extends JPanel {
	String message;
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9208904490186715373L;
	ResourceLoader iconResource = new ResourceLoader();
	int PlayerID = 1;
	String pl1Name = "Gracz1";
	String pl2Name = "Gracz2";
	JLabel token1;
	JLabel token2;

	public GameSideBoard() {
		setLayout(null);

		JPanel namesAndColours = new JPanel();
		namesAndColours.setBounds(10, 11, 169, 115);
		add(namesAndColours);
		namesAndColours.setLayout(null);

		JLabel player1 = new JLabel(pl1Name);
		player1.setBounds(5, 16, 91, 14);
		namesAndColours.add(player1);

		JLabel token1 = new JLabel("");
		token1.setBounds(119, 3, 40, 40);
		namesAndColours.add(token1);
		token1.setIcon(iconResource.get(HoleState.EMPTY)); // obrazek widoczny
															// arg plID [0-2]
															// BARTEK

		JLabel player2 = new JLabel(pl2Name);
		player2.setBounds(5, 78, 91, 14);
		namesAndColours.add(player2);

		JLabel token2 = new JLabel("");
		token2.setBounds(119, 65, 40, 40);
		namesAndColours.add(token2);
		token2.setIcon(null); // do metody bez obrazka BARTEK

		JLabel dialogWinow = new JLabel(message);
		dialogWinow.setVerticalAlignment(SwingConstants.TOP);
		dialogWinow.setBounds(8, 137, 169, 129);
		add(dialogWinow);

	}

	/**
	 * 
	 * METODY
	 * 
	 * do komunikacji z graczem ! BARTEK
	 */
	public void sendMessage(String message) {
		message = "Witamy w Connect4!";
		this.message = message;
	}

	public void displayCurrentToken(int player) {
		if (player == 1) {
			token1.setIcon(iconResource.get(HoleState.PLAYER1));
			token2.setIcon(null);
		} else {
			token2.setIcon(iconResource.get(HoleState.PLAYER2));
			token1.setIcon(null);
		}
	}

	public void setPl1Name(String i) {
		this.pl1Name = i;
	}

	public void setPl2Name(String i) {
		this.pl2Name = i;
	}
}
