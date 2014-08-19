package atrem;

public class Logic {
	private Board board;
	private int maxRows;
	private int maxSlots;
	HoleState token;

	public Logic(Board board) {
		this.board = board;
		maxSlots = board.getSlots();
		maxRows = board.getRows();
		this.checkIfWin();
	}

	public void checkIfWin() {

		for (int row = 0; row < maxRows; row++) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row, slot + 1)
						&& token == board.getHoleState(row, slot + 2)
						&& token == board.getHoleState(row, slot + 3)) {
					showWinner(board.getHoleState(row, slot));
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
					showWinner(board.getHoleState(row, slot));
			}
		}

		for (int row = 0; row < maxRows - 3; row++) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row + 1, slot + 1)
						&& token == board.getHoleState(row + 2, slot + 2)
						&& token == board.getHoleState(row + 3, slot + 3))
					showWinner(board.getHoleState(row, slot));
			}
		}

		for (int row = maxRows - 1; row >= 3; row--) {
			for (int slot = 0; slot < maxSlots - 3; slot++) {
				HoleState token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row - 1, slot + 1)
						&& token == board.getHoleState(row - 2, slot + 2)
						&& token == board.getHoleState(row - 3, slot + 3))
					showWinner(board.getHoleState(row, slot));
			}
		}
	}

	private void showWinner(HoleState holeState) {
		if (holeState.name() == "PLAYER1") {
			System.out.println("Wygra³ Gracz 1");
		} else if (holeState.name() == "PLAYER2") {
			System.out.println("Wygra³ Gracz 2");
		}
	}
}
