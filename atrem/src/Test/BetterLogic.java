package Test;

import atrem.Connect4.Game.LastMove;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.board.Board;

public class BetterLogic {

	LastMove lastMove;
	Board board;
	PlayerId checkedPlayer;
	private int sameTokenCounter;

	public BetterLogic(Board board, LastMove lastMove) {
		this.lastMove = lastMove;
		this.board = board;
	}

	public void checkDiagonalUP() {
		sameTokenCounter = 0;
		for (int row = lastMove.getLastRow(), slot = lastMove.getLastSlot(); row < endRow
				&& slot < endSlot; row++, slot++) {
			if (board.getHoleState(row, slot) == board
					.playerIdtoHoleState(checkedPlayer))
				sameTokenCounter++;
			else
				break;
		}

	}

	public void checkStartWithEnd(int lastSlot, int lastRow, int endRow,
			int endSlot) {
		int sameTokenCounter = 0;
		PlayerId checkedPlayer = lastMove.getPlayerId();
		if ((endRow > lastRow) && (endSlot > lastSlot))
			checkDiagonalUP();

		if (sameTokenCounter == 4)
			System.out.println("w chuj");// gora skos

	}

	int slot, endSlot, row, endRow;
	int maxSlot;
	int maxRow;

	public int targetPoint() {

		int lastSlot = lastMove.getLastSlot();
		int lastRow = lastMove.getLastRow();
		for (endSlot = -3; endSlot <= 3; endSlot += 3) {
			for (endRow = -3; endRow <= 3; endRow += 3) {
				int tempS = Math.abs(endSlot);
				int tempR = Math.abs(endRow);
				if (this.slot + endSlot > maxSlot && this.row + endRow > maxRow) {

					// checkStartWithEnd(lastSlot, lastRow, endRow, endSlot);

				}

			}
		}
		return sameTokenCounter;
	}
}
