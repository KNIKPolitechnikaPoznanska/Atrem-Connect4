package Test;

import atrem.Connect4.Game.board.Board;

public class BetterLogic {
	public void findWin(Board board) {

	}

	int slot, s, row, r;
	int maxSlot;
	int maxRow;

	public void targetPoint() {

		for (s = -3; s <= 3; s += 3) {
			for (r = -3; r <= 3; r += 3) {
				int tempS = Math.abs(s);
				int tempR = Math.abs(r);
				if (this.slot + s < maxSlot && this.row + r < maxRow) {
					break;
				}
			}
		}
	}
}