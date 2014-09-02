package atrem.Connect4.swing;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -1454524828392484548L;
	SwingPresenter swingPresenter;
	private SwingBoard board;
	GameSideBoard sideBoard;

	/**
	 * Create the frame.
	 */
	public GameFrame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 331);

		Container mainContainer = getContentPane();
		getContentPane().setLayout(null);
		board = new SwingBoard(swingPresenter);
		board.setBackground(new Color(255, 255, 255));
		board.setBounds(10, 0, 330, 282);
		mainContainer.add(board);
		sideBoard = new GameSideBoard();
		sideBoard.setBounds(340, 0, 186, 262);

		getContentPane().add(sideBoard);

	}

	public SwingBoard getPanel() {
		return board;
	}

	public GameSideBoard getBoczny() {
		return sideBoard;
	}

	public void setBoczny(GameSideBoard boczny) {
		this.sideBoard = boczny;
	}
}
