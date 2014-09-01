package atrem.Connect4.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	SwingPresenter swingPresenter;
	private Panel panel;
	private StatsPanel statsPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 331);

		Container mainContainer = getContentPane();
		getContentPane().setLayout(null);
		Panel panel = new Panel(swingPresenter);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 330, 282);
		mainContainer.add(panel);
		Boczny boczny = new Boczny();
		boczny.setBounds(340, 0, 186, 262);

		getContentPane().add(boczny);

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
