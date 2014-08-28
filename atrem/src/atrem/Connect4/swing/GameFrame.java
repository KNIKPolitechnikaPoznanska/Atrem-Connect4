package atrem.Connect4.swing;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import atrem.Connect4.Game.Game;

public class GameFrame extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9162854519449667347L;
	private Panel panel;
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

		panel = new Panel(game);
		statsPanel = new StatsPanel(game);
		getContentPane().setLayout(new BorderLayout(0, 0));
		mainContainer.add(panel, BorderLayout.CENTER);
		mainContainer.add(statsPanel, BorderLayout.EAST);
	}

	public Panel getPanel() {
		return panel;
	}

	public StatsPanel getStatsPanel() {
		return statsPanel;
	}

	public void setStatsPanel(StatsPanel statsPanel) {
		this.statsPanel = statsPanel;
	}
}
