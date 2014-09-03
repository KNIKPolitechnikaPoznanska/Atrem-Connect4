package atrem.Connect4.Game;

public class LastMove {
	private int lastSlot, lastRow;

	public LastMove() {
		lastRow = -1;
		lastSlot = -1;
	}

	public int getLastSlot() {
		return lastSlot;
	}

	public void setLastSlot(int lastSlot) {
		this.lastSlot = lastSlot;
	}

	public int getLastRow() {
		return lastRow;
	}

	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}

	public void saveLastMove(int slot, int row) {
		lastSlot = slot;
		lastRow = row;
	}
}
