package atrem.Connect4.swing;

import java.awt.EventQueue;

import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.Board;

public class SwingPresenter {
	private Game game;
	private int Slots;
	private int Rows;
	private int PlayerTurn;
	private int LastRow;
	private int LastSlot;
	private ResultState result;
	private GameController gameController;
	private Panel panel;
	private GameFrame gameFrame;

	public void setPresenter(Game game, GameController gameController) {
		this.game = game;
		this.gameController = gameController;
		setSettings();
	}

	public void runSettingsView() { // wywowlujemy okno dialogowe z ustawieniamy
									// row slot

	}

	public void setSettings() {
		Rows = game.getBoardRows();
		Slots = game.getBoardSlots();

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					GameFrame frame = new GameFrame(Rows, Slots);
					frame.setTitle("Connect 4");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		panel = gameFrame.getPanel();

	}

	public void runGameView(int Rows, int Slots, Board board) { // wyowlujemy
																// okno gry

	}

	public void goView(int LastRow, int LastSlot, ResultState result) {

	}

	public void getTurnFromView(int LastSlot) {
		gameController.setChoosedSlot(LastSlot);
	}

}
