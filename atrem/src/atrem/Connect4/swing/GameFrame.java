package atrem.Connect4.swing;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import atrem.Connect4.Game.Game;

public class GameFrame extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9162854519449667347L;
	Panel panel;
	private StatsPanel statsPanel;

	/**
	 * Create the frame.
	 * 
	 * @param game
	 */
	public GameFrame(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 300);
		Container mainContainer = getContentPane();
		mainContainer.setLayout(new GridBagLayout());
		panel = new Panel(game);
		statsPanel = new StatsPanel(game);
		mainContainer.add(panel);
		mainContainer.add(statsPanel);
	}

	public Panel getPanel() {
		return panel;
	}
}
