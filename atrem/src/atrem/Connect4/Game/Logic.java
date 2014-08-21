package atrem.Connect4.Game;

import atrem.Connect4.Console.GUI;

/*
 * Logika gry
 */
public class Logic {

	private int maxRows;
	private int maxSlots;
	private Game game;
	HoleState token;
	private boolean hasWinner = false;
	private GUI gui = new GUI();

	public Logic(Game game) {
		maxSlots = game.getBoard().getSlots();
		maxRows = game.getBoard().getRows();
		this.game = game;
		this.checkIfWin();
	}

	/*
	 * Sprawdzenie u³o¿enia 4 w 4 wariantach
	 */
	public boolean checkIfWin() {

		for (int row = 0; row < maxRows; row++) { // slot\kolumna
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = game.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == game.getBoard().getHoleState(row, slot + 1)
						&& token == game.getBoard().getHoleState(row, slot + 2)
						&& token == game.getBoard().getHoleState(row, slot + 3)) {
					hasWinner = gui.showWinner(token, game);
				}
			}
		}

		for (int slot = 0; slot < maxSlots; slot++) { // wiersz
			for (int row = 0; row < maxRows - 3; row++) {
				token = game.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == game.getBoard().getHoleState(row + 1, slot)
						&& token == game.getBoard().getHoleState(row + 2, slot)
						&& token == game.getBoard().getHoleState(row + 3, slot))
					hasWinner = gui.showWinner(token, game);
			}
		}

		for (int row = 0; row < maxRows - 3; row++) { // skos /
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = game.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == game.getBoard().getHoleState(row + 1,
								slot + 1)
						&& token == game.getBoard().getHoleState(row + 2,
								slot + 2)
						&& token == game.getBoard().getHoleState(row + 3,
								slot + 3))
					hasWinner = gui.showWinner(token, game);
			}
		}

		for (int row = maxRows - 1; row >= 3; row--) { // skos \
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				HoleState token = game.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == game.getBoard().getHoleState(row - 1,
								slot + 1)
						&& token == game.getBoard().getHoleState(row - 2,
								slot + 2)
						&& token == game.getBoard().getHoleState(row - 3,
								slot + 3))
					hasWinner = gui.showWinner(token, game);
			}
		}
		return hasWinner;
	}

	public boolean checkIfDraw(int doneMoves) {
		if (doneMoves == game.getBoard().getTotalSpots()) {
			gui.showRemis();
			return true;
		}
		return false;
	}

}
