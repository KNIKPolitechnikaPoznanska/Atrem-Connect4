package atrem.Connect4.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonListPanel extends JPanel {
	private int buttNumber = 0;
	JButton[] buttons;
	/**
	 * 
	 */
	private static final long serialVersionUID = 280580025464003711L;

	/**
	 * Create the panel.
	 */
	public ButtonListPanel() {
		buttons = new JButton[5];
		for (buttNumber = 0; buttNumber < buttons.length; buttNumber++) {
			buttons[buttNumber] = new JButton(Integer.toString(buttNumber + 1));
			add(buttons[buttNumber]);
			buttons[buttNumber].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					;
				}
			});
		}
	}
}
