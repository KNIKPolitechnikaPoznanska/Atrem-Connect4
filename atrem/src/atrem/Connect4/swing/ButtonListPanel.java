package atrem.Connect4.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import atrem.Connect4.Game.Game;

public class ButtonListPanel extends JPanel {
	private int buttNumber = 0;
	JButton[] buttons;
	Game game;
	private int slots;
	/**
	 * 
	 */
	private static final long serialVersionUID = 280580025464003711L;

	/**
	 * Create the panel.
	 * 
	 * @param game
	 */
	public ButtonListPanel(Game game) {
		this.game = game;
		slots = game.getBoardSlots();
		buttons = new JButton[slots];

		for (buttNumber = 0; buttNumber < buttons.length; buttNumber++) {
			buttons[buttNumber] = new JButton(Integer.toString(buttNumber + 1));
			add(buttons[buttNumber]);
			buttons[buttNumber].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					putToken(buttNumber);
				}
			});
		}
	}

	protected void putToken(int buttNumber2) {
		// GameController gc = new GameController();
		// gc.Loop();
	}
}
