package atrem.connect4.game;

import java.util.ArrayList;
import java.util.List;

import atrem.connect4.game.board.HoleState;

public class Logic {

	private int maxRows;
	private int maxSlots;
	private GameController gameController;
	private boolean cpuWin = false;
	private List<int[]> winningCoordinates;

	public Logic(GameController gameController) {
		this.gameController = gameController;
		maxSlots = gameController.getBoard().getSlots();
		maxRows = gameController.getBoard().getRows();
		setWinningCoordinates(new ArrayList<int[]>());
	}

	private boolean checkIfDraw(int doneMoves) {
		if (doneMoves == gameController.getBoard().getTotalSpots()) {
			gameController.setResult(ResultState.Draw);
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
				gameController.setResult(ResultState.Player1Win);
				break;
			case PLAYER2 :
				gameController.setResult(ResultState.Player2Win);
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

			for (int i = 0; i < getWinningCoordinates().size(); i++) {
				System.out.println(getWinningCoordinates().get(i)[0] + ", "
						+ getWinningCoordinates().get(i)[1]);
			}
			return true;

		}

		return false;
	}

	private void rememberCoordinates(int row, int slot) {
		int coordinates[] = new int[2];
		coordinates[0] = row;
		coordinates[1] = slot;
		getWinningCoordinates().add(coordinates);

	}

	private boolean checkIfThereIsAFour(int row, int slot, int i, int j) {
		if (getAddedNumbersOfNeighbours(row, slot, i, j) + 1 > 3) {
			return true;
		}
		getWinningCoordinates().clear();
		return false;

	}

	private int getAddedNumbersOfNeighbours(int row, int slot, int i, int j) {
		return countNeighboursInOneDirection(row, slot, i, j)
				+ countNeighboursInOneDirection(row, slot, -i, -j);
	}

	public int countNeighboursInOneDirection(int row, int slot, int i, int j) {
		rememberCoordinates(row, slot);

		if (checkIfHoleExists(row + i, slot + j)) {
			if ((gameController.getHoleState(row + i, slot + j) == gameController
					.getHoleState(row, slot))) {
				return countNeighboursInOneDirection(row + i, slot + j, i, j) + 1;

			}
		}

		return 0;
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

	public List<int[]> getWinningCoordinates() {
		return winningCoordinates;
	}

	public void setWinningCoordinates(List<int[]> winningCoordinates) {
		this.winningCoordinates = winningCoordinates;
	}

}
