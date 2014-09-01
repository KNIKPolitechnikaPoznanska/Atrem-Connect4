package atrem.Connect4.Game;

import atrem.Connect4.Game.board.HoleState;

/*
 * Logika gry
 */
public class Logic {
	private int maxRows;
	private int maxSlots;
	private GameController gameController;
	HoleState token;
	private boolean hasWinner = false;
	private boolean cpuWin = false;
	private String human = "human", cpu = "cpu";

	public Logic(GameController gameController) {
		this.gameController = gameController;
		maxSlots = gameController.getBoard().getSlots();
		maxRows = gameController.getBoard().getLastRow();
		// this.checkIfWin();
	}

	public boolean checkIfDraw(int doneMoves) {
		if (doneMoves == gameController.getBoard().getTotalSpots()) {
			gameController.setResult(ResultState.Draw);
			return true;
		}
		return false;
	}

	/*
	 * Sprawdzenie u³o¿enia 4 w 4 wariantach
	 */
	public boolean checkIfWin() {
		columnWin(human);
		rowWin(human);
		diagonalWin1(human);
		diagonalWin2(human);
		return hasWinner;
	}

	public boolean checkIfWinPC() {
		columnWin(cpu);
		rowWin(cpu);
		diagonalWin1(cpu);
		diagonalWin2(cpu);
		return cpuWin;
	}

	public boolean checkResult(int doneMoves) {
		checkIfWin();
		checkIfDraw(doneMoves);
		if (gameController.getResult() == ResultState.NoWin)
			return false;
		return true;
	}

	private void columnWin(String playerType) {
		for (int row = 0; row < maxRows; row++) { // slot\kolumna
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = gameController.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == gameController.getHoleState(row, slot + 1)
						&& token == gameController.getHoleState(row, slot + 2)
						&& token == gameController.getHoleState(row, slot + 3)) {
					setPlayerWon(playerType);
				}
			}
		}
	}

	private void diagonalWin1(String playerType) {
		for (int row = 0; row < maxRows - 3; row++) { // skos /
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = gameController.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
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
				if (token.getNumber() > 0
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
				if (token.getNumber() > 0
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
		}
		if (token.getNumber() == 1) {
			gameController.setResult(ResultState.Player1Win);
		} else if (token.getNumber() == 2) {
			gameController.setResult(ResultState.Player2Win);
		}
	}
}
