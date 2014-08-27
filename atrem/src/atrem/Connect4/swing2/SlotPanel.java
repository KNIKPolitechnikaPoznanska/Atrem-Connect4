package atrem.Connect4.swing2;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

public class SlotPanel extends JPanel {
	/**
	 * serial
	 */
	private static final long serialVersionUID = -1429466827813271904L;
	private static ResourceLoader iconResource = new ResourceLoader();

	public ResourceLoader getIconResource() {
		return iconResource;
	}

	private Game game;
	private JLabel[] holeIcon;

	public void setHoleIcon(JLabel sp, int n, Icon icon) {
		this.holeIcon[n].setIcon(icon);
	}

	private static int rows;

	/**
	 * Create the panel.
	 */
	public SlotPanel(Game game) {
		this.game = game;
		rows = game.getBoardRows();
		holeIcon = new JLabel[rows];

		for (int rowNumb = 0; rowNumb < rows; rowNumb++) {
			holeIcon[rowNumb] = new JLabel();
			add(holeIcon[rowNumb]);
			holeIcon[rowNumb].setIcon(iconResource.get(0));
		}
	}

	public void refreshPanel() {
		for (int rowNumb = 0; rowNumb < rows; rowNumb++) {
			// if()
			holeIcon[rowNumb].setIcon(iconResource.get(1));
		}
	}
}
