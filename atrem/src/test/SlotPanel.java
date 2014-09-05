package test;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SlotPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1429466827813271904L;
	ResourceLoader iconResource = new ResourceLoader();

	/**
	 * Create the panel.
	 */
	public SlotPanel(int rows) {

		JLabel[] HoleLabel = new JLabel[rows];
		for (int rowNum = 0; rowNum < rows; rowNum++) {
			HoleLabel[rowNum] = new JLabel();
			add(HoleLabel[rowNum]);
			HoleLabel[rowNum].setIcon(iconResource.get(0));

		}
	}
}
