package atrem.Connect4.swing.labelpanels;

import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

public class SlotPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1429466827813271904L;
	private ResourceLoader iconResource = new ResourceLoader();
	private Game game;
	private JLabel[] holeIcon;
	private int rows;

	/**
	 * Create the panel.
	 */
	public SlotPanel(Game game) {
		this.game = game;
		rows = game.getBoardRows();
		holeIcon = new JLabel[rows];
		for (int labelNumb = 0; labelNumb < holeIcon.length; labelNumb++) {
			holeIcon[labelNumb] = new JLabel();
			add(holeIcon[labelNumb]);
			holeIcon[labelNumb].setIcon(iconResource.get(0));
		}
	}

	public void refreshPanel() {
		for (int labelNumb = 0; labelNumb < holeIcon.length; labelNumb++) {
			// if()
		}
	}
}
