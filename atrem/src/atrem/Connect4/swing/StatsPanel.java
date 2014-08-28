package atrem.Connect4.swing;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

public class StatsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3441214335038105557L;
	JLabel pl1Label;
	JLabel pl2Label;

	/**
	 * Create the panel.
	 * 
	 * @param game
	 */
	public StatsPanel(Game game) {
		setLayout(new GridLayout(2, 1, 0, 0));

		pl1Label = new JLabel("Gracz1");
		pl2Label = new JLabel("Gracz2");
		add(pl1Label);
		add(pl2Label);

	}

}
