package Test;

import atrem.Connect4.Game.GameController;
import atrem.Connect4.Game.ResultState;
import atrem.Connect4.Game.board.HoleState;

public class BetterLogic {

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

	}

	private boolean checkIfThereIsAWinner(int row, int slot, HoleState token) {
		if (checkHorizontal(row, slot, token)
				|| checkVertical(row, slot, token)
				|| checkFirstDiagonal(row, slot, token)
				|| checkSecondDiagonal(row, slot, token))
			return true;

		return false;
	}

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
		}
	}
}
