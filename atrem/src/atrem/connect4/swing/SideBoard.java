package atrem.connect4.swing;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SideBoard extends JPanel {
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9208904490186715373L;
	private ResourceLoader icon = new ResourceLoader();
	private JLabel dialogWindow;
	private String pl1Name, pl2Name, message;
	private JLabel player1, player2;
	private DLabel token1, token2;
	private JPanel namesAndColours;
	private Color pl1Color, pl2Color;

	public SideBoard(Color pl1Color, Color pl2Color) {
		setLayout(null);
		this.pl1Color = pl1Color;
		this.pl2Color = pl2Color;

		namesAndColours = new JPanel();
		namesAndColours.setBackground(Color.ORANGE);
		namesAndColours.setBounds(0, 0, 216, 140);
		add(namesAndColours);
		namesAndColours.setLayout(null);

		player1 = new JLabel(pl1Name);
		player1.setBounds(5, 16, 91, 14);
		namesAndColours.add(player1);

		token1 = new DLabel(pl1Color, pl2Color);
		token1.setBounds(119, 3, 40, 40);
		namesAndColours.add(token1);

		token2 = new DLabel(pl1Color, pl2Color);
		token2.setBounds(119, 65, 40, 40);
		namesAndColours.add(token2);

		player2 = new JLabel(pl2Name);
		player2.setBounds(5, 78, 91, 14);
		namesAndColours.add(player2);

		dialogWindow = new JLabel(message);
		dialogWindow.setVerticalAlignment(SwingConstants.TOP);
		dialogWindow.setBounds(8, 137, 169, 129);
		add(dialogWindow);
	}

	public ResourceLoader getIconResource() {
		return icon;
	}

	/**
	 * METODY do komunikacji z graczem ! BARTEK
	 */
	public void sendMessage(String message) {
		message = "Witamy w Connect4!";
		this.message = message;
	}

	public void setPl1Name(String name) {
		this.pl1Name = name;
		player1.setText(pl1Name);
	}

	public void setPl2Name(String name) {
		this.pl2Name = name;
		player2.setText(pl2Name);
	}

	public void setTokenPl1() {
		token1.changeTo(pl1Color);
		token2.changeTo(pl2Color);
	}
	public void setTokenPl2() {
		token1.changeTo(pl2Color);
		token2.changeTo(pl1Color);
	}
}
