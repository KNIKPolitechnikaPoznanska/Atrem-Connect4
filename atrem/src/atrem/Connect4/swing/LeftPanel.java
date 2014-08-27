package atrem.Connect4.swing;

import java.awt.GridLayout;

import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

public class LeftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5802752411957281604L;
	private BoardPanel boardPane;
	private ButtonListPanel buttonList;

	/**
	 * Create the panel.
	 */
	public LeftPanel(Game game) {
		setLayout(new GridLayout(2, 1, 0, 0));
		buttonList = new ButtonListPanel(game);
		boardPane = new BoardPanel();
		add(buttonList);
		add(boardPane);
	}
}
