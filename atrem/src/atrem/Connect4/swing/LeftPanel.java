package atrem.Connect4.swing;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class LeftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5802752411957281604L;
	private BoardPanel boardPanel = new BoardPanel();
	private ButtonListPanel buttonList = new ButtonListPanel();

	/**
	 * Create the panel.
	 */
	public LeftPanel() {
		setLayout(new GridLayout(2, 1, 0, 0));
		add(buttonList);
		add(boardPanel);
	}
}
