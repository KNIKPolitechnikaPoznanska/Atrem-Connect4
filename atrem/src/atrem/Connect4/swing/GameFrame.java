package atrem.Connect4.swing;

import java.awt.Container;

import javax.swing.JFrame;

import atrem.Connect4.Game.Game;

public class GameFrame extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 9162854519449667347L;

	/**
	 * Create the frame.
	 * 
	 * @param game
	 */
	public GameFrame(Game game) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 300);

		Container mainContainer = getContentPane();
		Panel panel = new Panel(game);
		mainContainer.add(panel);

	}
}
