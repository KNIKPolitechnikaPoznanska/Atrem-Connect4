package atrem.Connect4.swing;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Stats extends JPanel {

	/**
	 * Create the panel.
	 */

	JLabel ranking;
	JLabel namePlayer1;
	JLabel namePlayer2;
	JLabel pointsPlayer1;
	JLabel pointsPlayer2;

	public Stats() {
		setBackground(new Color(255, 140, 0));
		setLayout(null);

		JLabel ranking = new JLabel("PUNKTACJA");
		ranking.setBackground(Color.CYAN);
		ranking.setBounds(92, 26, 102, 14);
		// lblGracz.setText("6969696");
		add(ranking);

		JLabel namePlayer1 = new JLabel("Gracz 1");
		namePlayer1.setBounds(40, 51, 83, 35);
		add(namePlayer1);

		JLabel namePlayer2 = new JLabel("Gracz 2");
		namePlayer2.setBounds(161, 61, 46, 14);
		add(namePlayer2);

		JLabel pointsPlayer1 = new JLabel("pkt1");
		pointsPlayer1.setBounds(38, 89, 46, 14);
		add(pointsPlayer1);

		JLabel pointsPlayer2 = new JLabel("pkt2");
		pointsPlayer2.setBounds(171, 89, 46, 14);
		add(pointsPlayer2);

	}

	public void setPointsPlayer1(int playerPoints) {
		pointsPlayer1.setText("" + playerPoints);
	}

	public void setPointsPlayer2(int playerPoints) {
		pointsPlayer2.setText("" + playerPoints);
	}

}
