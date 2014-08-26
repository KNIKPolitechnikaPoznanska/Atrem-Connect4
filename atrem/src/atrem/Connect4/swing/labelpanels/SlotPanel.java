package atrem.Connect4.swing.labelpanels;

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
	public SlotPanel() {
		JLabel[] HoleLabels = new JLabel[5];
		for (int labelNumb = 0; labelNumb < HoleLabels.length; labelNumb++) {
			HoleLabels[labelNumb] = new JLabel();
			add(HoleLabels[labelNumb]);
			HoleLabels[labelNumb].setIcon(iconResource.get(0));

		}
	}
}
