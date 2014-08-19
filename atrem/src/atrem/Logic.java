package atrem;

public class Logic {
	private Board board;
	private int rows;
	private int slots;
	HoleState token;

	public Logic() {
		slots = board.getSlots();
		rows = board.getRows();
		this.checkIfWin();
	}

	public void checkIfWin() {

		for (int row = 0; row < rows; row++) {
			for (int slot = 0; slot < slots - 3; slot++) {
				token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row, slot + 1)
						&& token == board.getHoleState(row, slot + 2)
						&& token == board.getHoleState(row, slot + 3)) {
					showWinner(board.getHoleState(row, slot));
				}
			}
		}

		for (int slot = 0; slot < slots; slot++) {
			for (int row = 0; row < rows - 3; row++) {
				token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row + 1, slot)
						&& token == board.getHoleState(row + 2, slot)
						&& token == board.getHoleState(row + 3, slot))
					showWinner(board.getHoleState(row, slot));
			}
		}

		for (int row = 0; row < rows - 3; row++) {
			for (int slot = 0; slot < slots - 3; slot++) {
				token = board.getHoleState(row, slot);
				if (token.getNumber() > 0
						&& token == board.getHoleState(row + 1, slot + 1)
						&& token == board.getHoleState(row + 2, slot + 2)
						&& token == board.getHoleState(row + 3, slot + 3))
					showWinner(board.getHoleState(row, slot));
			}
		}

		for (int row = rows - 1; row >= 3; row--) {
			for (int slot = 0; slot < slots - 3; slot++) {
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

	}

}
