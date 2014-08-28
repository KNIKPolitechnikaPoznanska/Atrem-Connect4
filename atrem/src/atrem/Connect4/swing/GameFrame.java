package atrem.Connect4.swing;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

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
	public GameFrame(SwingPresenter swingPresenter) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 550, 300);
		Container mainContainer = getContentPane();
		mainContainer.setLayout(new GridBagLayout());
		panel = new Panel(swingPresenter);
		statsPanel = new StatsPanel(swingPresenter);
		mainContainer.add(panel);
		swingPresenter.getFrame(this);
		mainContainer.add(statsPanel);
	}

	public Panel getPanel() {
		return panel;
	}
}
