package atrem.connect4.game;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import atrem.connect4.game.board.HoleState;

public class Logic {

	private int maxRows;
	private int maxSlots;
	private GameController gameController;
	private boolean cpuWin = false;
	private List<Point> winningCoordinates;

	public Logic(GameController gameController) {
		this.gameController = gameController;
		maxSlots = gameController.getBoard().getSlots();
		maxRows = gameController.getBoard().getRows();
		winningCoordinates = new ArrayList<Point>();
	}

	private boolean checkIfDraw(int doneMoves) {
		if (doneMoves == gameController.getBoard().getTotalSpots()) {
			gameController.setResult(ResultState.DRAW);
			return true;
		}
		return false;
	}

	public boolean getResultOfMove(int row, int slot, int doneMoves) {

		if (checkIfItIsAWinningMove(row, slot) || checkIfDraw(doneMoves)) {
			checkTheWinner(gameController.getHoleState(row, slot));
			return true;
		}

		return false;
	}

	private void checkTheWinner(HoleState token) {

		switch (token) {
			case PLAYER1 :
				gameController.setResult(ResultState.PLAYER_1_WIN);
				break;
			case PLAYER2 :
				gameController.setResult(ResultState.PLAYER_2_WIN);
				break;
			default :
				break;
		}
	}

	private boolean checkIfItIsAWinningMove(int row, int slot) {
		if (checkIfThereIsAFour(row, slot, 1, 1)
				|| checkIfThereIsAFour(row, slot, -1, 1)
				|| checkIfThereIsAFour(row, slot, 1, 0)
				|| checkIfThereIsAFour(row, slot, 0, 1)) {
			return true;
		}
		return false;
	}

	private boolean checkIfThereIsAFour(int row, int slot, int i, int j) {
		if (getAddedNumbersOfNeighbours(row, slot, i, j) + 1 > 3) {
			getAddedNumbersOfNeighboursAndSaveCoordinates(row, slot, i, j);
			return true;
		}
		return false;
	}
	private int getAddedNumbersOfNeighbours(int row, int slot, int i, int j) {
		return countNeighboursInOneDirection(row, slot, i, j)
				+ countNeighboursInOneDirection(row, slot, -i, -j);
	}

	public int countNeighboursInOneDirection(int row, int slot, int i, int j) {

		if (checkIfHoleExists(row + i, slot + j)) {
			if ((gameController.getHoleState(row + i, slot + j) == gameController
					.getHoleState(row, slot))) {
				return countNeighboursInOneDirection(row + i, slot + j, i, j) + 1;

			}
		}
		return 0;
	}

	private int getAddedNumbersOfNeighboursAndSaveCoordinates(int row,
			int slot, int i, int j) {
		return countNeighboursInOneDirectionAndSaveCoordinates(row, slot, i, j)
				+ countNeighboursInOneDirectionAndSaveCoordinates(row, slot,
						-i, -j);
	}

	public int countNeighboursInOneDirectionAndSaveCoordinates(int row,
			int slot, int i, int j) {

		saveCoordinates(row, slot);

		if (checkIfHoleExists(row + i, slot + j)) {
			if ((gameController.getHoleState(row + i, slot + j) == gameController
					.getHoleState(row, slot))) {
				return countNeighboursInOneDirectionAndSaveCoordinates(row + i,
						slot + j, i, j) + 1;

			}
		}
		return 0;

	}

	private void saveCoordinates(int row, int slot) {
		Point point = new Point();
		point.setLocation(row, slot);
		winningCoordinates.add(point);

	}

	private boolean checkIfHoleExists(int row, int slot) {
		if (row < 0 || slot < 0 || row >= maxRows || slot >= maxSlots) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkIfWinPC(int row, int slot) {
		if (checkIfItIsAWinningMove(row, slot))
			return cpuWin = true;
		return cpuWin = false;
	}

	public boolean getCPUwin() {
		return cpuWin;
	}

	public void setCPUwin(boolean CPUwin) {
		this.cpuWin = CPUwin;
	}

	public List<Point> getWinningCoordinates() {
		return winningCoordinates;
	}

	public void setWinningCoordinates(List<Point> winningCoordinates) {
		this.winningCoordinates = winningCoordinates;
	}

}
