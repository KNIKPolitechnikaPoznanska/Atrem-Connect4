package atrem.Connect4.Game;

public class Logic {

	private int maxRows;
	private int maxSlots;
	private Game game;
	HoleState token;
	private boolean hasWinner = false;

	public Logic(Game game) {
		maxSlots = game.getBoard().getSlots();
		maxRows = game.getBoard().getRows();
		this.game = game;
		this.checkIfWin();
	}

	public boolean checkIfWin() {

		for (int row = 0; row < maxRows; row++) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = game.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == game.getBoard().getHoleState(row, slot + 1)
						&& token == game.getBoard().getHoleState(row, slot + 2)
						&& token == game.getBoard().getHoleState(row, slot + 3)) {
					this.showWinner(token);
				}
			}
		}

		for (int slot = 0; slot < maxSlots; slot++) {
			for (int row = 0; row < maxRows - 3; row++) {
				token = game.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == game.getBoard().getHoleState(row + 1, slot)
						&& token == game.getBoard().getHoleState(row + 2, slot)
						&& token == game.getBoard().getHoleState(row + 3, slot))
					this.showWinner(token);
			}
		}

		for (int row = 0; row < maxRows - 3; row++) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = game.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == game.getBoard().getHoleState(row + 1,
								slot + 1)
						&& token == game.getBoard().getHoleState(row + 2,
								slot + 2)
						&& token == game.getBoard().getHoleState(row + 3,
								slot + 3))
					this.showWinner(token);
			}
		}

		for (int row = maxRows - 1; row >= 3; row--) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				HoleState token = game.getBoard().getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == game.getBoard().getHoleState(row - 1,
								slot + 1)
						&& token == game.getBoard().getHoleState(row - 2,
								slot + 2)
						&& token == game.getBoard().getHoleState(row - 3,
								slot + 3))
					this.showWinner(token);
			}
		}
		if (hasWinner)
			return true;
		else
			return false;
	}

	private void showWinner(HoleState holeState) {
		if (holeState.name() == "PLAYER1") {
			System.out.println("Wygra³ " + game.getPlayer1().getName());
		} else if (holeState.name() == "PLAYER2") {
			System.out.println("Wygra³ " + game.getPlayer2().getName());
		}
		hasWinner = true;
	}
}
