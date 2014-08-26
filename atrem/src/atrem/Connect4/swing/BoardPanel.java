package atrem.Connect4.swing;

import java.awt.GridLayout;

import javax.swing.JPanel;

import atrem.Connect4.swing.labelpanels.SlotPanel;

public class BoardPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7055501692808932769L;
	private SlotPanel slotPanel = new SlotPanel();

	/**
	 * Create the panel.
	 */
	public BoardPanel() {
		setLayout(new GridLayout(1, 0, 0, 0));
		add(slotPanel);

	}
}
