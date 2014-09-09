package atrem.connect4.swing;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.connect4.game.player.PlayerId;

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
		setBackground(Color.ORANGE);
		setLayout(null);

		ranking = new JLabel("PUNKTACJA");
		ranking.setBackground(Color.CYAN);
		ranking.setBounds(80, 26, 102, 14);
		// lblGracz.setText("6969696");
		add(ranking);

		namePlayer1 = new JLabel("Gracz 1");
		namePlayer1.setBounds(40, 51, 83, 35);
		add(namePlayer1);

		namePlayer2 = new JLabel("Gracz 2");
		namePlayer2.setBounds(161, 61, 46, 14);
		add(namePlayer2);

		pointsPlayer1 = new JLabel("pkt1");
		pointsPlayer1.setBounds(38, 89, 46, 14);
		add(pointsPlayer1);

		pointsPlayer2 = new JLabel("pkt2");
		pointsPlayer2.setBounds(171, 89, 46, 14);
		add(pointsPlayer2);

	}

	public void setPointsPlayer(int pointsPlayer, PlayerId player) {

		if (player == PlayerId.PLAYER1)
			pointsPlayer1.setText("" + pointsPlayer);
		else
			pointsPlayer2.setText("" + pointsPlayer);

	}

	public void setName(String name, PlayerId player) {
		if (player == PlayerId.PLAYER1)
			namePlayer1.setText(name);
		else
			namePlayer2.setText(name);
	}

}
