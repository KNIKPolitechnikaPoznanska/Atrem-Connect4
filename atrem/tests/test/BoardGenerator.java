package test;

import atrem.connect4.game.board.Board;
import atrem.connect4.game.board.HoleState;

public class BoardGenerator {
	static final int MAX_ROWS = 6, MAX_SLOTS = 7;
	Board board = new Board(MAX_ROWS, MAX_SLOTS);

	public void setDiagonalWinningFour(int startRow, int endRow, int startSlot,
			int endSlot) {
		for (int row = startRow, slot = startSlot; row < endRow
				&& slot < endSlot; row++, slot++) {
			board.setHoleState(row, slot, HoleState.PLAYER1);
		}
	}

	public void setVerticalOrHorizontalWinningFour(int startRow, int endRow,
			int startSlot, int endSlot) {
		if (startRow == endRow)
			for (int slot = startSlot; slot < endSlot; slot++) {
				board.setHoleState(startRow, slot, HoleState.PLAYER1);
			}
		else if (startRow == endRow)
			for (int row = startRow; row < endRow; row++) {
				board.setHoleState(row, startSlot, HoleState.PLAYER1);
			}
	}

	public Board getBoard() {
		return board;
	}

}
