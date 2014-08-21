package atrem.Connect4.Game.AI_adv;

import atrem.Connect4.Game.Board;
import atrem.Connect4.Game.Game;
import atrem.Connect4.Game.Logic;

public class AI_alfa {

	private AI_alfa[][] gameBoard;
	private int slots;
	private int rows;
	private Logic logic;
	private Game game;
	private Board board;

	public AI_alfa(Game game) {

		slots = game.getBoard().getSlots();
		rows = game.getBoard().getRows();
		this.game = game;
		this.board = game.getBoard();
		this.evaluateNextMouve();

	}

	public int evaluateNextMouve() {

		for (int row = 0; row < rows; rows++) {
			for (int slot = 0; slot < slots; slot++) {
				board.findFreeSpot(slot);

			}

		}
		return 0;
	}

	private Board nextMouve(Board nextBoard) {
		return nextBoard;
	}

}