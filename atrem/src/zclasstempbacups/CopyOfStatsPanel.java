package zclasstempbacups;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.connect4.swing.SwingPresenter;

public class CopyOfStatsPanel extends JPanel {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 3441214335038105557L;
	JLabel pl1Label;
	JLabel pl2Label;

	/**
	 * Create the panel.
	 * 
	 * @param swingPresenter
	 */
	public CopyOfStatsPanel(SwingPresenter swingPresenter) {
		setLayout(new GridLayout(2, 1, 0, 0));

		pl1Label = new JLabel("Gracz1");
		pl2Label = new JLabel("Gracz2");

		add(pl1Label);
		add(pl2Label);

	}

	public JLabel getPl1Label() {
		return pl1Label;
	}

	public JLabel getPl2Label() {
		return pl2Label;
	}

	public void setPl1LabelName(String pl1Label) {
		this.pl1Label.setText(pl1Label);
	}

	public void setPl2LabelName(String pl2Label) {
		this.pl2Label.setText(pl2Label);
	}
}
