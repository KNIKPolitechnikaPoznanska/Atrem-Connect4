package Test;

import atrem.Connect4.Game.LastMove;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.board.Board;

public class BetterLogic {
	LastMove lastMove;
	Board board;
	public void findWin(Board board, LastMove lastMove) {
		this.lastMove = lastMove;
		this.board = board;
	}
	public int checkDiagonalUP()
	{
		sameTokenCounter = 0;
		for (int row = lastRow, slot = lastSlot; row < endRow
				&& slot < endSlot; row++, slot++) {
			if(board.getHoleState(row, slot) == board.playerIdtoHoleState(checkedPlayer))
				sameTokenCounter++;
			else 
				break;
		}
}
	}
	public int sameTokenCounter;
	public void checkStartWithEnd(int lastSlot, int lastRow, int endRow,
			int endSlot) {
		int sameTokenCounter = 0;
		PlayerId checkedPlayer = lastMove.getPlayerId();
		if ((endRow > lastRow) && (endSlot > lastSlot)) // gora skos
			
	}
}
