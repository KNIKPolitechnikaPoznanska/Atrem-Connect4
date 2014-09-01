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

	public Logic(GameController gameController) {
		this.gameController = gameController;
		maxSlots = gameController.getBoard().getSlots();
		maxRows = gameController.getBoard().getLastRow();
		// this.game = game;
		// this.checkIfWin();
	}

	public boolean checkResult(int doneMoves) {
		checkIfWin();
		checkIfDraw(doneMoves);
		if (gameController.getResult() == ResultState.NoWin)
			return false;
		return true;
	}

	/*
	 * Sprawdzenie u³o¿enia 4 w 4 wariantach
	 */
	public boolean checkIfWin() {
		for (int row = 0; row < maxRows; row++) { // slot\kolumna
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = gameController.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == gameController.getHoleState(row, slot + 1)
						&& token == gameController.getHoleState(row, slot + 2)
						&& token == gameController.getHoleState(row, slot + 3)) {
					// hasWinner = gui.showWinner(token, game);
					setPlayerWon();
				}
			}
		}

		for (int slot = 0; slot < maxSlots; slot++) { // wiersz
			for (int row = 0; row < maxRows - 3; row++) {
				token = gameController.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == gameController.getHoleState(row + 1, slot)
						&& token == gameController.getHoleState(row + 2, slot)
						&& token == gameController.getHoleState(row + 3, slot))
					setPlayerWon();
			}
		}

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
					setPlayerWon();
			}
		}

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
					setPlayerWon();
			}
		}
		return hasWinner;
	}

	private void setPlayerWon() {
		if (token.getNumber() == 1) {
			gameController.setResult(ResultState.Player1Win);
		} else if (token.getNumber() == 2) {
			gameController.setResult(ResultState.Player2Win);
		}
	}

	public boolean checkIfDraw(int doneMoves) {
		if (doneMoves == gameController.getBoard().getTotalSpots()) {
			gameController.setResult(ResultState.Draw);
			return true;
		}
		return false;
	}

	public boolean checkIfWinPC() {
		for (int row = 0; row < maxRows; row++) { // slot\kolumna
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = gameController.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == gameController.getHoleState(row, slot + 1)
						&& token == gameController.getHoleState(row, slot + 2)
						&& token == gameController.getHoleState(row, slot + 3)) {
					// hasWinner = gui.showWinner(token, game);

					return true;
				}
			}
		}

		for (int slot = 0; slot < maxSlots; slot++) { // wiersz
			for (int row = 0; row < maxRows - 3; row++) {
				token = gameController.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == gameController.getHoleState(row + 1, slot)
						&& token == gameController.getHoleState(row + 2, slot)
						&& token == gameController.getHoleState(row + 3, slot))
					return true;
			}
		}

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
					return true;
			}
		}

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
					return true;
			}
		}
		return false;
	}
}
