package atrem.Connect4.Game;

public class LastMove {
	private int lastSlot;
	private int lastRow;

	public LastMove() {
		lastRow = 0;
		lastSlot = 0;
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
