package Test;

<<<<<<< HEAD
import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.HoleState;
=======
import atrem.Connect4.Game.LastMove;
import atrem.Connect4.Game.PlayerId;
import atrem.Connect4.Game.board.Board;
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

public class BetterLogic {

<<<<<<< HEAD
	private int maxRows;
	private int maxSlots;
	private GameController gameController;

	public BetterLogic(GameController gameController) {
		this.gameController = gameController;
		maxSlots = gameController.getBoard().getSlots();
		maxRows = gameController.getBoard().getRows();
	}

	private ResultState checkResultState(int row, int slot) {
		HoleState token = gameController.getHoleState(row, slot);

		if (checkIfThereIsAWinner(row, slot, token)
				&& token == HoleState.PLAYER1)
			return ResultState.Player1Win;
		if (checkIfThereIsAWinner(row, slot, token)
				&& token == HoleState.PLAYER2)
			return ResultState.Player2Win;

		return null;
=======
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
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

	}

<<<<<<< HEAD
	private boolean checkIfThereIsAWinner(int row, int slot, HoleState token) {
		if (checkHorizontal(row, slot, token)
				|| checkVertical(row, slot, token)
				|| checkFirstDiagonal(row, slot, token)
				|| checkSecondDiagonal(row, slot, token))
			return true;
=======
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
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

<<<<<<< HEAD
		return false;
	}
=======
	public int targetPoint() {
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git

<<<<<<< HEAD
	private boolean checkHorizontal(int row, int slot, HoleState token) {
		if (getAddedNumbersOfNeighbours(row, slot, 1, 0) > 3)
			return true;
		return false;

	}

	private boolean checkVertical(int row, int slot, HoleState token) {
		if (getAddedNumbersOfNeighbours(row, slot, 0, 1) > 3)
			return true;
		return false;

	}

	/*
	 * sprawdza przek¹tn¹ /
	 */
	private boolean checkFirstDiagonal(int row, int slot, HoleState token) {
		if (getAddedNumbersOfNeighbours(row, slot, 1, -1) > 3)
			return true;
		return false;

	}

	/*
	 * sprawdza przek¹tn¹ \
	 */
	private boolean checkSecondDiagonal(int row, int slot, HoleState token) {
		if (getAddedNumbersOfNeighbours(row, slot, 1, 1) > 3)
			return true;
		return false;
	}

	private int getAddedNumbersOfNeighbours(int row, int slot, int i, int j) {
		return countNeighboursInOneDirection(row, slot, i, j)
				+ countNeighboursInOneDirection(row, slot, -i, -j);
	}

	public int countNeighboursInOneDirection(int row, int slot, int i, int j) {

		if ((gameController.getHoleState(row + i, slot + j) == gameController
				.getHoleState(row, slot))
				&& checkIfHoleExists(row + i, slot + j))
			return countNeighboursInOneDirection(row, slot, i, j) + 1;

		return 1;
	}

	private boolean checkIfHoleExists(int row, int slot) {
		if (row < 0 || slot < 0 || row >= maxRows || slot >= maxSlots) {
			return false;
		} else {
			return true;
=======
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
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git
		}
		return sameTokenCounter;
	}
}
