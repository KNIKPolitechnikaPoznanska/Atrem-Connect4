package atrem;

public class Logic {
	private Board board;
	private int maxRows;
	private int maxSlots;
	private Player player1, player2;
	HoleState token;
	private boolean hasWinner = false;

	public Logic(Board board, Player player1, Player player2) {
		this.board = board;
		maxSlots = board.getSlots();
		maxRows = board.getRows();
		this.player1 = player1;
		this.player2 = player2;

		this.checkIfWin();
	}

	public boolean checkIfWin() {

		for (int row = 0; row < maxRows; row++) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row, slot + 1)
						&& token == board.getHoleState(row, slot + 2)
						&& token == board.getHoleState(row, slot + 3)) {
					this.showWinner(token);
				}
			}
		}

		for (int slot = 0; slot < maxSlots; slot++) {
			for (int row = 0; row < maxRows - 3; row++) {
				token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row + 1, slot)
						&& token == board.getHoleState(row + 2, slot)
						&& token == board.getHoleState(row + 3, slot))
					this.showWinner(token);
			}
		}

		for (int row = 0; row < maxRows - 3; row++) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row + 1, slot + 1)
						&& token == board.getHoleState(row + 2, slot + 2)
						&& token == board.getHoleState(row + 3, slot + 3))
					this.showWinner(token);
			}
		}

		for (int row = maxRows - 1; row >= 3; row--) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				HoleState token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row - 1, slot + 1)
						&& token == board.getHoleState(row - 2, slot + 2)
						&& token == board.getHoleState(row - 3, slot + 3))
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
			System.out.println("Wygra³" + player1.getName());
		} else if (holeState.name() == "PLAYER2") {
			System.out.println("Wygra³" + player2.getName());
		}
		hasWinner = true;
	}
}
