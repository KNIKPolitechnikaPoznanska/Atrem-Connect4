package atrem.Connect4.swing2;

import java.awt.GridLayout;

import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7055501692808932769L;
	private SlotPanel[] slotPanel;

	public void setSlotPanel(SlotPanel[] slotPanel) {
		this.slotPanel = slotPanel;
	}

	private int slots;

	/**
	 * Create the panel.
	 */
	public BoardPanel(Game game) {
		slots = game.getBoardSlots();
		slotPanel = new SlotPanel[slots];

		for (int slotNumb = 0; slotNumb < slots; slotNumb++) {
			slotPanel[slotNumb] = new SlotPanel(game);
			setLayout(new GridLayout(1, 0));
			add(slotPanel[slotNumb]);
			slotPanel[slotNumb].setLayout(new GridLayout(slots, 1));
		}

	}

	public SlotPanel getSlotPanel(int n) {
		return slotPanel[n];
	}
}
