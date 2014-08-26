package atrem.Connect4.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonListPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 280580025464003711L;

	/**
	 * Create the panel.
	 */
	public ButtonListPanel() {
		JButton[] buttons = new JButton[5];
		String[] names = { "1", "2", "3", "4", "5" };
		for (int buttNumber = 0; buttNumber < buttons.length; buttNumber++) {
			buttons[buttNumber] = new JButton(names[buttNumber]);
			add(buttons[buttNumber]);
			buttons[buttNumber].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// System.out.println(buttNumber);
				}
			});
		}
	}
}
