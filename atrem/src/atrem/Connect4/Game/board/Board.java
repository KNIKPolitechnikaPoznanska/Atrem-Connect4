package atrem.Connect4.Game.board;

/*
 * Tworzenie planszy 
 * poprzez wype³nienie obiektami klasy Hole
 */
public class Board {
	private int slots;
	private int rows;
	private Hole[][] gameBoard;
	private int totalSpots;
	private int lastSlot;
	private int lastSpot;

	public Board() {

		for (int i = 0; i < slots; i++)
			for (int j = 0; j < rows; j++)

				gameBoard[j][i] = new Hole();
	}

	public Board(int rows, int slots) {
		this.slots = slots;
		this.rows = rows;
		gameBoard = new Hole[rows][slots];
		for (int i = 0; i < this.slots; i++)
			for (int j = 0; j < this.rows; j++)
				gameBoard[j][i] = new Hole();
		totalSpots = slots * rows;
	}

	public void cleanSpot(int row, int slot)

	{
		setHoleState(row, slot, HoleState.EMPTY);
	}

	public int getTotalSpots() {
		return totalSpots;
	}

	public HoleState getHoleState(int Rows, int Slots) {
		return gameBoard[Rows][Slots].getHoleState();
	}

	public void setHoleState(int Rows, int Slots, HoleState holeState) {
		gameBoard[Rows][Slots].setHoleState(holeState);
	}

	public int getSlots() {
		return slots;
	}

	public int getRows() {
		return rows;
	}

	public int getLastSlot() {
		return lastSlot;
	}

	public void setLastSlot(int lastSlot) {
		this.lastSlot = lastSlot;
	}

	public int getLastSpot() {
		return lastSpot;
	}

	public void setLastSpot(int lastSpot) {
		this.lastSpot = lastSpot;
	}

	public int findFreeSpot(int slot) {
		int i = 0;
		for (i = 0; i < getRows(); i++) {
			HoleState holeState = getHoleState(i, slot);
			if (i == 0 && holeState != HoleState.EMPTY) // gdy jest pelen
				return -1;
			if (holeState != HoleState.EMPTY) {
				{
					return i - 1;
				}
			}
		}
		return i - 1;
	}
}
