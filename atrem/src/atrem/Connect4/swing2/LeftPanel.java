package atrem.Connect4.swing2;

import java.awt.FlowLayout;
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
		setLayout(new FlowLayout(2, 0, 0));
		buttonList = new ButtonListPanel(game);
		boardPane = new BoardPanel(game);
		add(buttonList);
		buttonList.setLayout(new GridLayout(2, 6));
		add(boardPane);
		boardPane.setLayout(new GridLayout(3, 2));
	}
}
