package atrem.Connect4.Game;

import atrem.Connect4.Game.board.HoleState;

public class Logic {

	private int maxRows;
	private int maxSlots;
	private GameController gameController;
	private boolean cpuWin = false;

	public Logic(GameController gameController) {
		this.gameController = gameController;
		maxSlots = gameController.getBoard().getSlots();
		maxRows = gameController.getBoard().getRows();

	}

	private boolean checkIfDraw(int doneMoves) {
		if (doneMoves == gameController.getBoard().getTotalSpots()) {
			gameController.setResult(ResultState.Draw);
			return true;
		}
		return false;
	}

	public boolean checkIfWinPC(int row, int slot) {
		if (checkIfThereIsAFour(row, slot, 1, 1)
				|| checkIfThereIsAFour(row, slot, -1, 1)
				|| checkIfThereIsAFour(row, slot, 1, 0)
				|| checkIfThereIsAFour(row, slot, 0, 1))
			return cpuWin = true;

		return cpuWin = false;
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
				|| checkIfThereIsAFour(row, slot, 0, 1))
			return true;

		return false;
	}

	private boolean checkIfThereIsAFour(int row, int slot, int i, int j) {
		if (getAddedNumbersOfNeighbours(row, slot, i, j) + 1 > 3)
			return true;
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

	private boolean checkIfHoleExists(int row, int slot) {
		if (row < 0 || slot < 0 || row >= maxRows || slot >= maxSlots) {
			return false;
<<<<<<< HEAD
		} else {
			return true;
=======
		return true;
	}

	private void columnWin(String playerType) {
		for (int row = 0; row < maxRows; row++) { // slot\kolumna
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = gameController.getHoleState(row, slot);
				if (token != HoleState.EMPTY
						&& token == gameController.getHoleState(row, slot + 1)
						&& token == gameController.getHoleState(row, slot + 2)
						&& token == gameController.getHoleState(row, slot + 3)) {
					setPlayerWon(playerType);
				}
			}
		}
	}

	private boolean sprIfa(boolean row, boolean slot, LastMove lastmove) {
		int rows = 0;
		int slots = 0;

		for (int i = 0; i < 3; i++) {
			if (row) {
				rows++;
			}
			if (slot) {
				slots++;
			}
		}
		return true;
	}

	// potem zamieni� za warunki
	// private boolean checkNextHole(int row, int slot) {
	// return token == gameController.getHoleState(row, slot);
	// }

	private void diagonalWin1(String playerType) {
		for (int row = 0; row < maxRows - 3; row++) { // skos /
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = gameController.getBoard().getHoleState(row, slot);
				if (token != HoleState.EMPTY
						&& token == gameController.getHoleState(row + 1,
								slot + 1)
						&& token == gameController.getHoleState(row + 2,
								slot + 2)
						&& token == gameController.getHoleState(row + 3,
								slot + 3))
					setPlayerWon(playerType);
			}
		}
	}

	private void diagonalWin2(String playerType) {
		for (int row = maxRows - 1; row >= 3; row--) { // skos \
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				HoleState token = gameController.getHoleState(row, slot);
				if (token != HoleState.EMPTY
						&& token == gameController.getHoleState(row - 1,
								slot + 1)
						&& token == gameController.getHoleState(row - 2,
								slot + 2)
						&& token == gameController.getHoleState(row - 3,
								slot + 3))
					setPlayerWon(playerType);
			}
		}
	}

	private void rowWin(String playerType) {
		for (int slot = 0; slot < maxSlots; slot++) { // wiersz
			for (int row = 0; row < maxRows - 3; row++) {
				token = gameController.getBoard().getHoleState(row, slot);
				if (token != HoleState.EMPTY
						&& token == gameController.getHoleState(row + 1, slot)
						&& token == gameController.getHoleState(row + 2, slot)
						&& token == gameController.getHoleState(row + 3, slot))
					setPlayerWon(playerType);
			}
		}
	}

	private void setPlayerWon(String playerType) {
		if (playerType == cpu) {
			cpuWin = true;
			return;
		}
		if (token == HoleState.PLAYER1) {
			gameController.setResult(ResultState.Player1Win);
		} else if (token == HoleState.PLAYER2) {
			gameController.setResult(ResultState.Player2Win);
>>>>>>> branch 'master' of https://github.com/KNIKPolitechnikaPoznanska/AtremProject.git
		}
	}

	public boolean getCPUwin() {
		return cpuWin;
	}

	public void setCPUwin(boolean CPUwin) {
		this.cpuWin = CPUwin;
	}

}
