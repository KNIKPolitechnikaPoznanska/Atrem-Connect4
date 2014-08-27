package atrem.Connect4.swing2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.Game.player.PlayerController;

public class ButtonListPanel extends JPanel {
	JButton[] button;
	Game game;
	private int slots;
	private int btNumber;
	/**
	 * 
	 */
	private static final long serialVersionUID = 280580025464003711L;

	/**
	 * Create the panel with button list on LeftPanel.
	 * 
	 * @param game
	 */
	public ButtonListPanel(Game game) {
		this.game = game;
		slots = game.getBoardSlots();
		button = new JButton[slots];

		for (int buttonNumber = 0; buttonNumber < button.length; buttonNumber++) {
			button[buttonNumber] = new JButton(
					Integer.toString(buttonNumber + 1));
			add(button[buttonNumber]);

			button[buttonNumber].setMinimumSize(new Dimension(1, 1));
			button[buttonNumber].setPreferredSize(new Dimension(30, 30));
			button[buttonNumber].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Object buttonSender = e.getSource();
					putToken(buttonSender);
				}
			});
		}
	}

	protected void putToken(Object buttonSender) {
		for (int bNumber = 0; bNumber < slots; bNumber++) {
			if (buttonSender == button[bNumber]) {
				System.out.println(bNumber + 1);
				Board board = game.getBoard();
				PlayerController player = game.getPlayer1();
				// board.go(player);
				System.out.println(player.getName());

			}
		}

	}

	public void setPlayer1() {

	}
}
