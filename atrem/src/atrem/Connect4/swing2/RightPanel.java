package atrem.Connect4.swing2;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

public class RightPanel extends JPanel {
	private JLabel Pl1Label;
	private JLabel Pl2Label;
	/**
	 * serial
	 */
	private static final long serialVersionUID = 7873520130383730085L;
	private Game game;

	/**
	 * Create the panel.
	 */
	public RightPanel(Game game) {
		this.game = game;
		setLayout(new GridLayout(6, 1, 0, 0));

		Pl1Label = new JLabel("Gracz1");
		add(Pl1Label);

		Pl2Label = new JLabel("Gracz2");
		add(Pl2Label);
	}

}
