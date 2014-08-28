package atrem.Connect4.swing;

import Test.C4gui;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.Board;
import atrem.Connect4.

public class SwingPresenter {
	private Game game;
	private int Slots;
	private int Rows;
	private int PlayerTurn;
	private int LastRow;
	private int LastSlot;
	private ResultState result;
	private GameController gameController;
	private C4gui c4gui;
	

	public void setPresenter(Game game, GameController gameController) {
		this.game = game;
		this.gameController = gameController;
	}

	public void runSettingsView() { // wywowlujemy okno dialogowe z ustawieniamy
									// row slot

	}

	public void setSettings(int Rows, int Slots) {
		this.Rows = Rows;
		this.Slots = Slots;
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
